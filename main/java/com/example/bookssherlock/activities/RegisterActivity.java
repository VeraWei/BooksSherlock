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

        // TODO Add real data from form
//        String user = findViewById(R.id.et_name).getContext().toString();
//        String email = findViewById(R.id.email).getContext().toString();
//        String pwd = findViewById(R.id.password).getContext().toString();
//        String re_pwd = findViewById(R.id.et_repassword).getContext().toString();

        String user = "qiuming";
        String email = "qiuming@gmail.com";
        String pwd = "123456";
        String re_pwd = "123456";

        final Button btn = findViewById(R.id.btn_register);

        btn.setOnClickListener(v -> {

            if (TextUtils.isEmpty(user)) {

                this.noticeText = "Username is empty";
                this.notification();

            } else if (TextUtils.isEmpty(email)) {

                this.noticeText = "Email is empty";
                this.notification();

            } else if (TextUtils.isEmpty(pwd)) {

                this.noticeText = "Password is empty";
                this.notification();

            }  else if (!pwd.equals(re_pwd)) {

                this.noticeText = "You should enter the same characters for password";
                this.notification();

            } else {

//                this.save(email, user, pwd);
                startActivity(new Intent(this, BooksListActivity.class));
                finish();
            }
        });
    }

    private void save(final String email, final String name, final String password) {
        SQLiteDatabase writableDatabase = this.helper.getWritableDatabase();
        final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        writableDatabase.execSQL(
                "INSERT INTO users (user_id, email,name,password) values (?,?,?,?);",
                new String[]{email, name, password, format.format(new Date())}
        );
    }

    private void notification() {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast.makeText(context, this.noticeText, duration).show();
    }
}