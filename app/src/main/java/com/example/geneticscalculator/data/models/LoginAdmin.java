package com.example.geneticscalculator.data.models;

public class LoginAdmin {
    private final String passkey;
    private final String admlogin;

    public LoginAdmin(String passkey, String admlogin){
        this.passkey = passkey;
        this.admlogin = admlogin;
    }

    public String getPasskey() {
        return passkey;
    }

    public String getAdmlogin() {
        return admlogin;
    }
}
