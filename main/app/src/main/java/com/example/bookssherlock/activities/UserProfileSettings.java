package com.example.bookssherlock.activities;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookssherlock.MainActivity;
import com.example.bookssherlock.R;
import com.example.bookssherlock.models.db.DbUser;
import com.example.bookssherlock.sqlite.DbHelper;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserProfileSettings extends AppCompatActivity {

    private DbHelper dbHelper;

    private DbUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_settings);

        final BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new NavigationBarListener(this));
        this.dbHelper = DbHelper.getInstance(this);

        final Intent intent = getIntent();
        user = (DbUser) intent.getSerializableExtra("user");

        final TextView userName = (TextView) findViewById(R.id.txtUserName);
        final TextView address = (TextView) findViewById(R.id.txtStreet);

        userName.setText(user.getUsername());
        address.setText(user.getAddress());

        final EditText fullNameInput = (EditText) findViewById(R.id.inputFirstName);
        final EditText addressInput = (EditText) findViewById(R.id.inputAddress);

        final Button updateSettings = (Button) findViewById(R.id.btnUpdate);
        final Button submitChanges = (Button) findViewById(R.id.btnSelect);

        updateSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setUserName(fullNameInput.getText().toString());
                user.setAddress(addressInput.getText().toString());

                userName.setText(user.getUsername());
                address.setText(user.getAddress());

                final String email = user.getEmail();

                updateUser(fullNameInput.getText().toString(), addressInput.getText().toString(), email);
            }
        });

        submitChanges.setOnClickListener(view -> {
            Intent anotherIntent = new Intent(this, UserProfile.class);
            startActivity(anotherIntent);
        });
    }

    private void updateUser(final String name, final String address, final String email) {
        SQLiteDatabase writableDatabase = this.dbHelper.getWritableDatabase();

        writableDatabase.execSQL("UPDATE users SET name = ? , address = ? WHERE email = ?", new Object[]{name,address,email});




        // SQLiteDatabase db = this.dbHelper.getWritableDatabase();

        // ContentValues contentValues = new ContentValues();

        //contentValues.put("Field1", name);
        //contentValues.put("Field2", address);

        // db.execSQL("UPDATE users SET name = ? AND address = ? WHERE email = ?");
    }
}
