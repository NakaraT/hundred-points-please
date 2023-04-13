package com.example.geneticscalculator.data.datasource;
import com.example.geneticscalculator.data.models.LoginUser;
import com.example.geneticscalculator.data.models.LoginAdmin;

public class AccountsDataSource {

    public boolean checkLoginUserValid(LoginUser loginUser){
        return loginUser.getLogin().equals("") && loginUser.getPassword().equals("");
    }

    public boolean checkAdminUserValid(LoginAdmin loginAdministrator){
        return loginAdministrator.getAdmlogin().equals("nakarat") && loginAdministrator.getPasskey().equals("");
    }
}