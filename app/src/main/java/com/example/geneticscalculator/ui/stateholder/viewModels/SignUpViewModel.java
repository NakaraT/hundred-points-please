package com.example.geneticscalculator.ui.stateholder.viewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.geneticscalculator.data.models.LoginAdmin;
import com.example.geneticscalculator.data.repositories.AccountsRepository;

public class SignUpViewModel extends AndroidViewModel {
    private final AccountsRepository repository = new AccountsRepository(getApplication());

    public SignUpViewModel(@NonNull Application application) {
        super(application);
    }

    public boolean loginAccount(String login, String password, boolean allowed) {
        LoginAdmin admin = new LoginAdmin(login, password);
        return repository.adminLogin(admin, allowed);
    }

}
