package com.example.bookssherlock.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bookssherlock.R;
import com.example.bookssherlock.models.AvailableBooks;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BookActivity extends AppCompatActivity {

    private AvailableBooks currentBook;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.books_detail);
        initView();
        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new NavigationBarListener(this));
        // See offer button refer to the offer list
        final Button seeOffers = (Button) findViewById(R.id.btnSeeOffers);
        seeOffers.setOnClickListener(v -> {
            Intent offerPage = new Intent(BookActivity.this, BookOffers.class);
            //int bookID = book.getBookId();
            offerPage.putExtra("bookID",this.currentBook.getBookId());
            startActivity(offerPage);
        });
    }

    private void initView() {
        final ImageView imageView = findViewById(R.id.imgBookCover);
        final Intent intent = getIntent();
        this.currentBook = (AvailableBooks) intent.getSerializableExtra("book");
        imageView.setImageResource(getResources().getIdentifier(currentBook.getImage(), "drawable", getPackageName()));
        final TextView author = findViewById(R.id.textBookAuthor);
        author.setText(currentBook.getAuthor());

        final TextView title = findViewById(R.id.textbookTitle);
        title.setText(currentBook.getTitle());

        final TextView desc = findViewById(R.id.textBookDesc);
        desc.setText(currentBook.getDescription());
    }
}
