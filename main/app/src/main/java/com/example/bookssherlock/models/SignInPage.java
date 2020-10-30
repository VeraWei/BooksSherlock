package com.example.bookssherlock.models;


public class SignInPage implements Credentials {
    private final String email;
    private final String password;
    private final String username;
    private final String confirmPassword;

    public SignInPage(String email, String password, String username, String confirmPassword) {
        this.email = email;
        this.password = password;
        this.username = username;
        this.confirmPassword = confirmPassword;
    }


    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return username;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }
}
