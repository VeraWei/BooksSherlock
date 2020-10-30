package com.example.bookssherlock.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookssherlock.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserProfileSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_settings);
        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new NavigationBarListener(this));
    }
}