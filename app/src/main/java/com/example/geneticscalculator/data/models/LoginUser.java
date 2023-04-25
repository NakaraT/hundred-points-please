package com.example.geneticscalculator.data.models;

public class LoginUser {
    private final String number;
    private final String password;

    public LoginUser(String login, String password){
        this.number = login;
        this.password = password;

    }
    public String getNumber() {
        return number;
    }

    public String getPassword() {
        return password;
    }
}
