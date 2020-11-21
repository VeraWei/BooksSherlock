package com.example.bookssherlock.activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookssherlock.R;
import com.example.bookssherlock.models.AvailableBooks;
import com.example.bookssherlock.sqlite.DbHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BooksListActivity extends AppCompatActivity {

    private DbHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);
        this.helper = DbHelper.getInstance(this);
        SearchView searchView = findViewById(R.id.searchView);
        ListView listView = findViewById(R.id.listView);
        listView.setOnItemClickListener((parent, view, position, id) -> startActivity(new Intent(this, BookActivity.class)));
        SQLiteDatabase readableDatabase = this.helper.getReadableDatabase();
        List<AvailableBooks> availableBooks = this.booksList();
        ArrayAdapter<AvailableBooks> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                availableBooks
        );
        listView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });

        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new NavigationBarListener(this));
    }

    @Override
    protected void onDestroy() {
        this.helper.close();
        super.onDestroy();
    }

    private List<AvailableBooks> booksList() {
        final List<AvailableBooks> books = new ArrayList<>();
        SQLiteDatabase readableDatabase = this.helper.getReadableDatabase();
        Cursor cursor = readableDatabase.rawQuery("SELECT * from books;", null);
        while (cursor.moveToNext()) {
            books.add(
                    new AvailableBooks(
                            cursor.getInt(cursor.getColumnIndex("id")),
                            cursor.getString(cursor.getColumnIndex("description")),
                            cursor.getString(cursor.getColumnIndex("title"))
                    )
            );
        }
        return books;
    }
}

