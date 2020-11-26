package com.example.bookssherlock.models;

public class Carts {

    private final int sellerBookId;

    private final String image;

    private final String title;

    private final int price;

    private final int cartId;

    public Carts(int sellerBookId, String image, String title,int price,int cartId) {
        this.sellerBookId = sellerBookId;
        this.image = image;
        this.title = title;
        this.price = price;
        this.cartId = cartId;
    }

    public int getPrice() {
        return price;
    }

    public int getSellerBookId() {
        return sellerBookId;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public int getCartId() {
        return cartId;
    }
}
