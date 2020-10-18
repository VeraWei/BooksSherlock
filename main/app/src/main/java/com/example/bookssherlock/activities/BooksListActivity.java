package com.example.bookssherlock.activities;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bookssherlock.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BooksListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);
        final ActionBar toolBar = getSupportActionBar();

        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    toolBar.setTitle("Home");
                    return true;
                case R.id.navigation_cards:
                    toolBar.setTitle("Cards");
                    return true;
                case R.id.navigation_price:
                    toolBar.setTitle("Books List");
                    return true;
                case R.id.navigation_profile:
                    toolBar.setTitle("My Profile");
                    return true;
                default:
                    return false;
            }
        });
    }
}