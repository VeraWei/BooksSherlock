package com.example.bookssherlock.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.bookssherlock.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserProfileSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_settings);
        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    startActivity(new Intent(this, BooksListActivity.class));
                    finish();
                    break;
                case R.id.navigation_profile:
                    startActivity(new Intent(this, UserProfile.class));
                    finish();
                    break;
                case R.id.navigation_books:
                    startActivity(new Intent(this, MyBooksActivity.class));
                    finish();
                    break;
                case R.id.navigation_cards:
                    startActivity(new Intent(this, MyCardsActivity.class));
                    finish();
                    break;
            }
            return true;

        });
    }
}