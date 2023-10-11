package com.example.geneticscalculator.data.models;

import androidx.annotation.Nullable;

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

    @Override
    public boolean equals(@Nullable Object obj) {
        return obj instanceof LoginUser
                && number.equals(((LoginUser) obj).number)
                && password.equals(((LoginUser) obj).password);
    }
}
