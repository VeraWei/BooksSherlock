package com.example.bookssherlock.models;

import java.io.Serializable;

/**
 * List of books.
 */
public class AvailableBooks implements Serializable {

    private final int bookId;

    private final String image;

    private final String description;

    private final String title;

    private final String author;

    public AvailableBooks(int bookId, String image, String title, final String description, final String author) {
        this.bookId = bookId;
        this.image = image;
        this.title = title;
        this.description = description;
        this.author = author;
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

    public String getDescription() {
        return description;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
