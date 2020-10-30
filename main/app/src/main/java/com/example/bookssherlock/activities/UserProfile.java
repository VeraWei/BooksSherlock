package com.example.bookssherlock.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookssherlock.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserProfile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new NavigationBarListener(this));
        final ImageView img = findViewById(R.id.imgSettings);
        img.setOnClickListener(v -> startActivity(new Intent(this, UserProfileSettings.class)));
    }
}