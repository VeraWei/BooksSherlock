package com.example.bookssherlock;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.bookssherlock.activities.BooksListActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        Button signUp = findViewById(R.id.btn_register);
        signUp.setOnClickListener(v->{
            startActivity(new Intent(this, BooksListActivity.class));
            finish();
        });
        //TODO use credentials
    }
}