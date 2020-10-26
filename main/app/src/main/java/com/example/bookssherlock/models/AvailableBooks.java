package com.example.bookssherlock.models;

import lombok.Data;
import lombok.ToString;

/**
 * List of books.
 */
@Data
public class AvailableBooks {

    private final int bookId;

    private final String image;

    private final String title;

    @Override
    public String toString() {
        return this.title;
    }
}
