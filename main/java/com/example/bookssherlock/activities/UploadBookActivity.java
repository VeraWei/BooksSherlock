package com.example.bookssherlock.activities;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListPopupWindow;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookssherlock.R;
import com.example.bookssherlock.models.AvailableBooks;
import com.example.bookssherlock.sqlite.DbHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UploadBookActivity extends AppCompatActivity {

    private List<AvailableBooks> books;

    private DbHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_book);
        final EditText chooseBook = findViewById(R.id.chooseBook);
        this.helper = DbHelper.getInstance(this);
        this.books = this.helper.booksList();
        final ListPopupWindow listPopupWindow = new ListPopupWindow(this);
        listPopupWindow.setModal(true);
        listPopupWindow.setAdapter(
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        this.books
                )
        );
        listPopupWindow.setAnchorView(chooseBook);
        listPopupWindow.setOnItemClickListener((parent, view, position, id) -> {
            chooseBook.setText(this.books.get(position).getTitle());
            listPopupWindow.dismiss();
        });
        chooseBook.setOnClickListener(v -> listPopupWindow.show());

        final EditText price = findViewById(R.id.choosePrice);
        final SharedPreferences sh = getSharedPreferences("storage", Context.MODE_PRIVATE);
        final String email = sh.getString("email", null);
        final Button button = findViewById(R.id.button);

        button.setOnClickListener(v -> {
            this.save(email, Integer.parseInt(price.getText().toString()), chooseBook.getText().toString());
            AlertDialog alert = new AlertDialog.Builder(this).create();
            alert.setTitle("Book was uploaded");
            alert.setButton(DialogInterface.BUTTON_POSITIVE, "OK", (dialog, which) -> startActivity(new Intent(this, MyBooksActivity.class)));
            alert.show();
        });
    }


    private void save(final String email, final int price, final String bookTitle) {
        SQLiteDatabase writableDatabase = this.helper.getWritableDatabase();
        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        writableDatabase.execSQL(
                "INSERT INTO seller_book (seller_id,price,book_id,date) values ((select id from users where email = ?),?,(select id from books where title=?),?);",
                new Object[]{email, price, bookTitle, format.format(new Date())}
        );
    }

}