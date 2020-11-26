package com.example.bookssherlock.activities;

import android.content.Intent;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bookssherlock.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationBarListener implements BottomNavigationView.OnNavigationItemSelectedListener {

    private final AppCompatActivity parent;

    public NavigationBarListener(AppCompatActivity parent) {
        this.parent = parent;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                this.parent.startActivity(new Intent(this.parent, BooksListActivity.class));
                this.parent.finish();
                break;
            case R.id.navigation_profile:
                this.parent.startActivity(new Intent(this.parent, UserProfile.class));
                this.parent.finish();
                break;
            case R.id.navigation_books:
                this.parent.startActivity(new Intent(this.parent, MyBooksActivity.class));
                this.parent.finish();
                break;
            case R.id.navigation_cards:
                this.parent.startActivity(new Intent(this.parent, MyCardsActivity.class));
                this.parent.finish();
                break;
        }
        return true;
    }
}
