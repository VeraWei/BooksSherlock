package com.example.bookssherlock.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookssherlock.R;
import com.example.bookssherlock.models.AvailableBooks;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Arrays;
import java.util.List;

public class BooksListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);
        SearchView searchView = findViewById(R.id.searchView);
        ListView listView = findViewById(R.id.listView);
        listView.setOnItemClickListener((parent, view, position, id) -> startActivity(new Intent(this, BookActivity.class)));

        List<AvailableBooks> availableBooks = Arrays.asList(
                new AvailableBooks(1, "", "War and Peace"),
                new AvailableBooks(1, "", "Head First Java"),
                new AvailableBooks(1, "", "Crime and Punishment")
        );
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

}

