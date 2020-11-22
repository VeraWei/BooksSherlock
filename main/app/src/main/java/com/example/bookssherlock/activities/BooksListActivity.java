package com.example.bookssherlock.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookssherlock.R;
import com.example.bookssherlock.adapters.BookListAdapter;
import com.example.bookssherlock.models.AvailableBooks;
import com.example.bookssherlock.sqlite.DbHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

public class BooksListActivity extends AppCompatActivity {

    private DbHelper helper;

    private List<AvailableBooks> books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);
        this.helper = DbHelper.getInstance(this);
        this.books = this.helper.booksList();
        SearchView searchView = findViewById(R.id.searchView);
        ListView listView = findViewById(R.id.listView);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, BookActivity.class);
            intent.putExtra("book", this.books.get(position));
            startActivity(intent);
        });
        ArrayAdapter<AvailableBooks> adapter = new BookListAdapter(
                this,
                R.layout.list_book,
                this.books
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

        final BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new NavigationBarListener(this));
    }

    @Override
    protected void onDestroy() {
        this.helper.close();
        super.onDestroy();
    }

}

