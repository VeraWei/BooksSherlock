package com.example.bookssherlock.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.bookssherlock.R;
import com.example.bookssherlock.models.AvailableBooks;
import com.example.bookssherlock.models.db.SellerBooks;
import com.example.bookssherlock.sqlite.DbHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class BookOffers extends AppCompatActivity {


    private DbHelper helper;
    private List<SellerBooks> offers;
    private int bookID;
    private String email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_offers);

        this.helper = DbHelper.getInstance(this);
        ListView offerList = findViewById(R.id.offerList);
        this.offers = this.offers();
        final SharedPreferences sh = getSharedPreferences("storage", Context.MODE_PRIVATE);
        this.email = sh.getString("email", null);

        ArrayAdapter<SellerBooks> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_multiple_choice,
                this.offers
        );
        offerList.setAdapter(adapter);
        //the submit button control the actions of adding item to cart
        final Button addToCart = (Button) findViewById(R.id.btnAddToCart);
        addToCart.setOnClickListener(v -> {
            // check the checkboxes state
            SparseBooleanArray checkedItems = offerList.getCheckedItemPositions();
            ArrayList<SellerBooks> checkedBooks = new ArrayList<>();
            if (checkedItems != null) {
                for (int i = 0; i < checkedItems.size(); i++) {
                    if (checkedItems.valueAt(i)) {

                        // String s = offerList.getAdapter().getItem(checkedItems.keyAt(i)).toString();
                        //s contains your checked item, checkedItems.keyAt(i) is the index of the checked item
                        checkedBooks.add(offers.get(i));
                        //Toast.makeText(getApplicationContext(), checkedBooks.get(0),Toast.LENGTH_SHORT).show();
                    }
                }
                SQLiteDatabase writableDatabase = helper.getWritableDatabase();
                for (SellerBooks cart : checkedBooks) {
                    writableDatabase.execSQL("INSERT INTO carts(user_id,seller_book_id) values ((select id from users where email = ?),?)", new Object[]{email,cart.getId()});
                }
            }
            SQLiteDatabase readableDatabase = helper.getReadableDatabase();
            Cursor c = readableDatabase.rawQuery("SELECT count(*) as count from carts",null);
            while(c.moveToNext()){
               int count =  c.getInt(c.getColumnIndex("count"));
                System.out.println(count);
            }
        });


    }


    private List<SellerBooks> offers() {
        //Retrieve the bookid from the BookActivity
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.bookID = extras.getInt("bookID");
            //The key argument here must match that used in the other activity
        }

        final List<SellerBooks> offers = new ArrayList<>();
        SQLiteDatabase readableDatabase = this.helper.getReadableDatabase();
        Cursor cursor = readableDatabase.rawQuery("SELECT s.price as price,b.title as title,s.id as id,s.date as date from seller_book s inner join books b on b.id = s.book_id WHERE b.id = ?;", new String[]{String.valueOf(this.bookID)});
        while (cursor.moveToNext()) {
            offers.add(
                    new SellerBooks(
                            cursor.getInt(cursor.getColumnIndex("id")),
                            cursor.getString(cursor.getColumnIndex("title")),
                            cursor.getInt(cursor.getColumnIndex("price")),
                            cursor.getString(cursor.getColumnIndex("date"))
                    )
            );
        }
//        SQLiteDatabase writableDatabase = this.helper.getWritableDatabase();
//        writableDatabase.execSQL("INSERT INTO carts(user_id,seller_id) values ((select id from users where email = ?),?)",new Object[]{this.email});
        return offers;
    }
}
