package com.example.bookssherlock.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bookssherlock.R;
import com.example.bookssherlock.models.Orders;
import com.example.bookssherlock.sqlite.DbHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MyBooksActivity extends AppCompatActivity {

    private DbHelper helper;

    private List<Orders> orders;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_books);
        this.helper = DbHelper.getInstance(this);

        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new NavigationBarListener(this));

        SharedPreferences sh = getSharedPreferences("storage", Context.MODE_PRIVATE);
        String email = sh.getString("email", null);
        this.setBooks(email);

        ListView listView = findViewById(R.id.orderedBooks);
        ArrayAdapter<Orders> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                this.orders
        );
        listView.setAdapter(adapter);

        final Button button = findViewById(R.id.uploadBtn);
        button.setOnClickListener(v -> startActivity(new Intent(this,UploadBookActivity.class)));
    }

    private void setBooks(final String email) {
        final List<Orders> ordersList = new ArrayList<>();
        SQLiteDatabase readableDatabase = this.helper.getReadableDatabase();
        Cursor cursor = readableDatabase.rawQuery(
                "SELECT o.status as status,b.title as title,o.price as price ,o.date as date from orders o inner join users u on u.id = o.buy_id and u.email = ?" +
                        " inner join seller_book s on s.id = o.seller_b_id" +
                        " inner join books b on b.id = s.book_id;",
                new String[]{email});
        while (cursor.moveToNext()) {
            ordersList.add(
                    new Orders(
                            cursor.getString(cursor.getColumnIndex("status")),
                            cursor.getString(cursor.getColumnIndex("title")),
                            cursor.getInt(cursor.getColumnIndex("price")),
                            cursor.getString(cursor.getColumnIndex("date"))
                    )
            );
        }
        this.orders = ordersList;
    }
}
