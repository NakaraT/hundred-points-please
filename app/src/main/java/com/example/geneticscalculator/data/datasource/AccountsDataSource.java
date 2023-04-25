package com.example.geneticscalculator.data.datasource;
import com.example.geneticscalculator.data.models.LoginUser;
import com.example.geneticscalculator.data.models.LoginAdmin;

public class AccountsDataSource {

    public boolean checkLoginUserValid(LoginUser loginUser){
        return loginUser.getNumber().equals("")
                && loginUser.getPassword().equals("");
    }

    public boolean checkAdminUserValid(LoginAdmin loginAdministrator){
        return loginAdministrator.getAdmnumber().equals("79299084570")
                && loginAdministrator.getPasskey().equals("");
    }
}
