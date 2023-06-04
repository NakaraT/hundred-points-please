package com.example.geneticscalculator;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class UserDataWorker extends Worker {
    public final Context context;
    public static final String KEY_LOG = "YAWP";

    public UserDataWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        String phone = getInputData().getString(KEY_LOG);
        String filename = "Number";
        File dir = context.getFilesDir();
        File file_phone = new File(dir, filename);
        try {
            FileOutputStream fos = new FileOutputStream(file_phone);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
            writer.write(phone);
            writer.close();
            fos.close();
            return Result.success();
        } catch (IOException e) {
            return Result.failure();
        }
    }
}
