package com.example.bookssherlock.models;

public class LoginPage implements Credentials {

    private final String email;

    private final String password;

    public LoginPage(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }
}
