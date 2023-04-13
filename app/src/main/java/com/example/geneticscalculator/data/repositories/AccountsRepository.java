package com.example.geneticscalculator.data.repositories;

import com.example.geneticscalculator.data.protocols.AccountsProtocol;
import com.example.geneticscalculator.data.datasource.AccountsDataSource;
import com.example.geneticscalculator.data.models.LoginAdmin;
import com.example.geneticscalculator.data.models.LoginUser;

public class AccountsRepository implements AccountsProtocol {
    private final AccountsDataSource dataSource = new AccountsDataSource();

    @Override
    public boolean adminLogin(LoginAdmin loginAdministrator) {
        return dataSource.checkAdminUserValid(loginAdministrator);
    }

    @Override
    public boolean userLogin(LoginUser loginUser) {
        return dataSource.checkLoginUserValid(loginUser);
    }

}