package com.example.geneticscalculator.ui.stateholder.viewModels;

import androidx.lifecycle.ViewModel;

import com.example.geneticscalculator.data.models.LoginAdmin;
import com.example.geneticscalculator.data.repositories.AccountsRepository;

public class SignUpViewModel extends ViewModel {
    private final AccountsRepository repository = new AccountsRepository();

    public boolean loginAccount(String login, String password) {
        LoginAdmin admin = new LoginAdmin(login, password);
        return repository.adminLogin(admin);
    }

}
