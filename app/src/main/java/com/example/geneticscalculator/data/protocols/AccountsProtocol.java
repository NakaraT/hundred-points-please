package com.example.geneticscalculator.data.protocols;
import com.example.geneticscalculator.data.models.LoginAdmin;
import com.example.geneticscalculator.data.models.LoginUser;

public interface AccountsProtocol {

    boolean adminLogin(LoginAdmin loginAdministrator);

    boolean userLogin(LoginUser loginUser);

}
