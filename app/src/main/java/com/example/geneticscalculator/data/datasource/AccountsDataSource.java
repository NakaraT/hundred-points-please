package com.example.geneticscalculator.data.datasource;

import android.content.Context;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import com.example.geneticscalculator.data.models.LoginUser;
import com.example.geneticscalculator.data.models.LoginAdmin;

public class AccountsDataSource {
    private final Context context;

    public AccountsDataSource(Context context) {
        this.context = context;
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
