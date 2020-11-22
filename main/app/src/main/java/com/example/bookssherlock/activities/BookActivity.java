package com.example.bookssherlock.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bookssherlock.R;
import com.example.bookssherlock.models.AvailableBooks;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.books_detail);
        initView();
        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new NavigationBarListener(this));
    }

    private void initView() {
        final ImageView imageView = findViewById(R.id.imgBookCover);
        final Intent intent = getIntent();
        final AvailableBooks book = (AvailableBooks) intent.getSerializableExtra("book");
        imageView.setImageResource(getResources().getIdentifier(book.getImage(), "drawable", getPackageName()));
        final TextView author = findViewById(R.id.textBookAuthor);
        author.setText(book.getAuthor());

        final TextView title = findViewById(R.id.textbookTitle);
        title.setText(book.getTitle());

        final TextView desc = findViewById(R.id.textBookDesc);
        desc.setText(book.getDescription());
    }
}
