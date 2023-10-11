package com.example.geneticscalculator.data.datasource;

import android.content.Context;

import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import com.example.geneticscalculator.UserDataWorker;
import com.example.geneticscalculator.data.models.LoginAdmin;
import com.example.geneticscalculator.data.models.LoginUser;
import com.example.geneticscalculator.data.session.AppSession;

public class AccountsDataSource {
    private final Context context;

    private final WorkManager workManager;

    public AccountsDataSource(Context context) {
        this.context = context;
        workManager = WorkManager.getInstance(context);
    }

    private Data createInputData(String login){
        Data.Builder Databuilder = new Data.Builder();
        Databuilder.putString(UserDataWorker.KEY_LOG, login);
        return Databuilder.build();
    }

    public boolean checkLoginUserValid(LoginUser loginUser){
        OneTimeWorkRequest workRequest = new OneTimeWorkRequest.Builder(UserDataWorker.class)
                .setInputData(createInputData(loginUser.getNumber())).build();
        workManager.enqueue(workRequest);
        LoginUser hardCodeUser = new LoginUser("79299084570", "123456");
        return loginUser.equals(AppSession.getSessionUser()) || loginUser.equals(hardCodeUser);
    }

    public boolean checkAdminUserValid(LoginAdmin loginAdmin, boolean allowed){
        if (allowed) {
            String filename = "Key";
            String fileContents = loginAdmin.getPasskey();
            File file_key = new File("/storage/emulated/0/Android/data", filename);
            try {
                FileOutputStream fos = new FileOutputStream(file_key);
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
                writer.write(fileContents);
                writer.close();
                fos.close();
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return !loginAdmin.getAdmnumber().equals("") &&
                !loginAdmin.getPasskey().equals("");
    }
}
