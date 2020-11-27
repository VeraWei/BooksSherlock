package com.example.bookssherlock.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookssherlock.MainActivity;
import com.example.bookssherlock.R;
import com.example.bookssherlock.models.AvailableBooks;
import com.example.bookssherlock.models.db.DbUser;
import com.example.bookssherlock.sqlite.DbHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class UserProfile extends AppCompatActivity {

    private DbHelper dbHelper;

    private DbUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        this.dbHelper = DbHelper.getInstance(this);

        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new NavigationBarListener(this));

        final ImageView imgSettings = findViewById(R.id.imgSettings);
        final ImageView imgLogout = findViewById(R.id.imgSignOut);

        imgSettings.setOnClickListener(view -> {
            Intent intent = new Intent(this, UserProfileSettings.class);
            intent.putExtra("user", this.user);
            startActivity(intent);
        });

        imgLogout.setOnClickListener(view -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });

        SharedPreferences sh = getSharedPreferences("storage", Context.MODE_PRIVATE);

        String email = sh.getString("email", null);

        this.setUser(email);

        TextView userName = findViewById(R.id.txtUserName);
        userName.setText(this.user.getUsername());

    }

    private void setUser(final String email) {
        SQLiteDatabase readableDatabase = this.dbHelper.getReadableDatabase();

        Cursor cursor = readableDatabase.rawQuery("SELECT * from users where email = ? limit 1;", new String[]{email});

        while (cursor.moveToNext()) {
           this.user =  new DbUser(
                    cursor.getString(cursor.getColumnIndex("name")),
                    cursor.getString(cursor.getColumnIndex("email")),
                    cursor.getString(cursor.getColumnIndex("password")),
                    cursor.getString(cursor.getColumnIndex("address")),
                    cursor.getInt(cursor.getColumnIndex("id"))
            );
        }
    }
}