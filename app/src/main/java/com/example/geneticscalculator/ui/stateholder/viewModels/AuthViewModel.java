package com.example.geneticscalculator.ui.stateholder.viewModels;

import androidx.lifecycle.ViewModel;

import com.example.geneticscalculator.data.models.LoginUser;
import com.example.geneticscalculator.data.repositories.AccountsRepository;

public class AuthViewModel extends ViewModel {
    private final AccountsRepository accountsRepository = new AccountsRepository();

    public boolean loginAccount(String login, String password){
        LoginUser loginUser = new LoginUser(login, password);
        return accountsRepository.userLogin(loginUser);
    }
}
