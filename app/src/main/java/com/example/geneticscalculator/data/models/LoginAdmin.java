package com.example.geneticscalculator.data.models;

public class LoginAdmin {
    private final String passkey;
    private final String admnumber;

    public LoginAdmin(String passkey, String admlogin){
        this.passkey = passkey;
        this.admnumber = admlogin;
    }

    public String getPasskey() {
        return passkey;
    }

    public String getAdmnumber() {
        return admnumber;
    }
}
