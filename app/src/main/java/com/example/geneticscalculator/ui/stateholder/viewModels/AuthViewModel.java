package com.example.geneticscalculator.ui.stateholder.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.geneticscalculator.data.models.LoginUser;
import com.example.geneticscalculator.data.repositories.AccountsRepository;

public class AuthViewModel extends AndroidViewModel {
    private final AccountsRepository accountsRepository = new AccountsRepository(getApplication());

    public AuthViewModel(@NonNull Application application) {
        super(application);
    }

    public boolean loginAccount(String login, String password){
        LoginUser loginUser = new LoginUser(login, password);
        return accountsRepository.userLogin(loginUser);
    }
}
