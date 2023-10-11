package com.example.geneticscalculator.data.session;

import com.example.geneticscalculator.data.models.LoginUser;

public class AppSession {

    private static LoginUser sessionUser = null;

    public static void setSessionUser(LoginUser user) {
        sessionUser = user;
    }

    public static LoginUser getSessionUser() {
        return sessionUser;
    }
}
