package com.example.bookssherlock.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bookssherlock.R;
import com.example.bookssherlock.adapters.CartsAdapter;
import com.example.bookssherlock.models.Carts;
import com.example.bookssherlock.sqlite.DbHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MyCardsActivity extends AppCompatActivity {

    private DbHelper dbHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carts);
        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new NavigationBarListener(this));
        this.dbHelper = DbHelper.getInstance(this);
        SharedPreferences sh = getSharedPreferences("storage", Context.MODE_PRIVATE);
        String email = sh.getString("email", null);
        final List<Carts> carts = this.getCarts(email);

        ListView listView = findViewById(R.id.myCarts);
        ArrayAdapter<Carts> adapter = new CartsAdapter(
                this,
                R.layout.carts_list,
                carts,
                this.dbHelper,
                email
        );
        listView.setAdapter(adapter);
    }

    private List<Carts> getCarts(final String email) {
        final List<Carts> carts = new ArrayList<>();
        SQLiteDatabase readableDatabase = this.dbHelper.getReadableDatabase();
        Cursor cursor = readableDatabase.rawQuery("SELECT c.id as id,s.id as sellerId,s.price as price,b.title as title,b.icon as icon from carts c " +
                        "inner join seller_book s on s.id = c.seller_book_id inner join books b on b.id = s.book_id where c.user_id = (select id from users where email = ?)",
                new String[]{email}
        );
        while (cursor.moveToNext()) {
            carts.add(
                    new Carts(
                            cursor.getInt(cursor.getColumnIndex("sellerId")),
                            cursor.getString(cursor.getColumnIndex("icon")),
                            cursor.getString(cursor.getColumnIndex("title")),
                            cursor.getInt(cursor.getColumnIndex("price")),
                            cursor.getInt(cursor.getColumnIndex("id"))
                    )
            );
        }
        return carts;
    }
}
