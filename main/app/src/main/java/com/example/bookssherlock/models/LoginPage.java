package com.example.bookssherlock.models;

import lombok.Data;

@Data
public class LoginPage implements Credentials {

    private final String email;

    private final String password;
}
