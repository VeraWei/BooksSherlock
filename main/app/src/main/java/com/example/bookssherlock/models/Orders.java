package com.example.bookssherlock.models;

public class Orders {

    //"SELECT o.status,b.title,o.price,o.date
    private final String status;

    private final String title;

    private final int price;

    private final String date;

    public Orders(String status, String title, int price, String date) {
        this.status = status;
        this.title = title;
        this.price = price;
        this.date = date;
    }

    public String getStatus() {
        return status;
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
        return String.format(
                "Date: %s,\t Status: %s\n Book: %s",
                this.date,
                this.status,
                this.title
        );
    }
}
