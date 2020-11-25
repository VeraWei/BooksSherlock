package com.example.bookssherlock.models.db;

public class SellerBooks {
    //id,seller_id,price,book_id,date
    private int id;
    private String title;
    private int price;
    private String date;

    public SellerBooks(int id, String title, int price, String date) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return String.format("Price %d\n Title: %s",this.price,this.title);
    }
}
