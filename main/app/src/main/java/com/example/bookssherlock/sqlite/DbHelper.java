package com.example.bookssherlock.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bookssherlock.R;

public class DbHelper extends SQLiteOpenHelper {

    private static DbHelper helper;

    private Context context;

    public static DbHelper getInstance(Context context) {
        if (helper == null) {
            helper = new DbHelper(context);
        }
        return helper;
    }

    private DbHelper(Context context) {
        super(context, "books", null, 1);
        this.context = context;
        context.deleteDatabase("books");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table users(id INTEGER PRIMARY KEY,email varchar(255) unique,name varchar(255),password varchar(255));\n");
        db.execSQL("create table books(id int primary key,title varchar(255),description varchar(255),rating int,icon text,author text);\n");
        db.execSQL("create table seller_book(id int primary key,seller_id int references users(id),price int,book_id int references books(id),date text);\n");
        db.execSQL("create table orders(id int primary key,buy_id int references users(id),seller_b_id int references seller_book (id),price int,status varchar(255))");
        db.execSQL("create table carts(id integer primary key AUTOINCREMENT,seller_book_id int references seller_book(id),user_id int references users(id));");
        final String warPeace = this.context.getResources().getResourceEntryName(R.drawable.warpeace);
        final String crime = this.context.getResources().getResourceEntryName(R.drawable.crime);
        db.execSQL("INSERT into books(id,title,description,icon,author) values (1,'War and peace','War and peace','" + warPeace + "','Tolstoy'),(2,'Crime and Punishment','Crime and Punishment','" + crime + "','Dostoevskiy');");
        db.execSQL("INSERT into users(id,email,name,password) values (1,'buyer@gmail.com','dsd','sdsd'),(2,'seller@gmail.com','dsd','sdsd')");
        db.execSQL("INSERT into seller_book(id,seller_id,price,book_id,date) values (1,2,200,1,'2020-07-10');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
