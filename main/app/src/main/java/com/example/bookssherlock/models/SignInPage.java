package com.example.bookssherlock.models;

import lombok.Data;

@Data
public class SignInPage implements Credentials {
    private final String email;
    private final String password;
    private final String username;
    private final String confirmPassword;
}
