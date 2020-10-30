package com.example.bookssherlock.models;

/**
 * List of books.
 */
public class AvailableBooks {

    private final int bookId;

    private final String image;

    private final String title;

    public AvailableBooks(int bookId, String image, String title) {
        this.bookId = bookId;
        this.image = image;
        this.title = title;
    }

    public int getBookId() {
        return bookId;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
