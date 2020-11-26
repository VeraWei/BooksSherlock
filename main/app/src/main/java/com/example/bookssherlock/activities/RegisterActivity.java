package com.example.bookssherlock.activities;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bookssherlock.MainActivity;
import com.example.bookssherlock.R;
import com.example.bookssherlock.sqlite.DbHelper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterActivity extends AppCompatActivity {

    private DbHelper helper;
    private String noticeText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        this.helper = DbHelper.getInstance(this);

        EditText  userText = findViewById(R.id.et_name);
        EditText emailText = findViewById(R.id.email);
        EditText pwdText = findViewById(R.id.password);
        EditText rePsdText = findViewById(R.id.et_repassword);

        final Button btn = findViewById(R.id.btn_register);

        btn.setOnClickListener(v -> {

            if (TextUtils.isEmpty(userText.getText().toString())) {

                this.noticeText = "Username is empty";
                this.notification();

            } else if (TextUtils.isEmpty(emailText.getText().toString())) {

                this.noticeText = "Email is empty";
                this.notification();

            } else if (TextUtils.isEmpty(pwdText.getText().toString())) {

                this.noticeText = "Password is empty";
                this.notification();

            }  else if (!pwdText.getText().toString().equals(rePsdText.getText().toString())) {

                this.noticeText = "You should enter the same characters for password";
                this.notification();

            } else {

                this.save(emailText.getText().toString(), userText.getText().toString(), pwdText.getText().toString());
                startActivity(new Intent(this, MainActivity.class));
                finish();
            }
        });
    }

    private void save(final String email, final String name, final String password) {
        SQLiteDatabase writableDatabase = this.helper.getWritableDatabase();

        writableDatabase.execSQL(
                "INSERT INTO users (email,name,password) values (?,?,?);",
                new String[]{email, name, password}
        );
    }

    private void notification() {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, this.noticeText, duration).show();
    }
}