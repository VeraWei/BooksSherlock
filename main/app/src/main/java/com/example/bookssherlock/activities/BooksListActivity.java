package com.example.bookssherlock.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.bookssherlock.R;

public class BooksListActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private BookListAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);
        recyclerView = findViewById(R.id.recyclerView);

    }

}