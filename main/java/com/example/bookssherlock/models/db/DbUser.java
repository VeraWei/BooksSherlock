package com.example.bookssherlock.models.db;

import com.example.bookssherlock.models.Credentials;

public class DbUser implements Credentials, Identifiable {

    private final String username;

    private final String email;

    private final String password;

    private final String address;

    private final int id;

    public DbUser(String username, String email, String password, String address, int id) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return password;
    }


    public String getAddress() {
        return address;
    }

    @Override
    public int getId() {
        return id;
    }
}
