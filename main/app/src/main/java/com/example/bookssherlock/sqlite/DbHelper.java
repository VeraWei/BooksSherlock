package com.example.bookssherlock.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    private static DbHelper helper;

    public static DbHelper getInstance(Context context) {
        if (helper == null) {
            helper = new DbHelper(context);
        }
        return helper;
    }

    private DbHelper(Context context) {
        super(context, "books", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(id INTEGER PRIMARY KEY,email varchar(255) unique,name varchar(255),password varchar(255));\n");
        db.execSQL("create table books(id int primary key,title varchar(255),description varchar(255),rating int);\n");
        db.execSQL("create table seller_book(id int primary key,seller_id int references users(id),price int,book_id int references books(id),date int);\n");
        db.execSQL("create table orders(id int primary key,buy_id int references users(id),seller_b_id int references seller_book (id),price int,status varchar(255))");
        db.execSQL("create table carts(id int primary key,seller_book_id int references seller_book(id),user_id int references users(id));");
        db.execSQL("INSERT into books(id,title,description) values (null,'War and peace','War and peace'),(null,'Crime and Punishment','Crime and Punishment');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
