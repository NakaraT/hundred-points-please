package com.example.geneticscalculator.data.repositories;

import android.content.Context;
import com.example.geneticscalculator.data.protocols.AccountsProtocol;
import com.example.geneticscalculator.data.datasource.AccountsDataSource;
import com.example.geneticscalculator.data.models.LoginAdmin;
import com.example.geneticscalculator.data.models.LoginUser;

public class AccountsRepository implements AccountsProtocol {
    private final Context context;
    private final AccountsDataSource dataSource;
    public AccountsRepository(Context context){
        this.context = context;
        dataSource = new AccountsDataSource(context);
    }
    @Override
    public boolean adminLogin(LoginAdmin loginAdmin, boolean allowed) {
        return dataSource.checkAdminUserValid(loginAdmin, allowed);
    }

    @Override
    public boolean userLogin(LoginUser loginUser) {
        return dataSource.checkLoginUserValid(loginUser);
    }

}