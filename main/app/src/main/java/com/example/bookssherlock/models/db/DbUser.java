package com.example.bookssherlock.models.db;

import com.example.bookssherlock.models.Credentials;

import lombok.Data;

@Data
public class DbUser implements Credentials, Identifiable {

    private final String username;

    private final String email;

    private final String password;

    private final String address;

    private final int id;

}
