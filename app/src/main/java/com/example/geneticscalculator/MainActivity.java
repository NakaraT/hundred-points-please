package com.example.geneticscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "geneticscalculator";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast toast1 = Toast.makeText(getApplicationContext(),
                "Приложение создано.", Toast.LENGTH_SHORT);
        toast1.show();
        Log.i(TAG, "Приложение было успешно создано");
        setContentView(R.layout.activity_main);
    }

    protected void onDestroy() {
        super.onDestroy();
        Toast toast2 = Toast.makeText(getApplicationContext(),
                "Приложение закрыто.", Toast.LENGTH_SHORT);
        toast2.show();
        Log.e(TAG, "Приложение было успешно закрыто");
    }

    protected void onRestart() {
        super.onRestart();
        Toast toast3 = Toast.makeText(getApplicationContext(),
                "Приложение перезапущено.", Toast.LENGTH_SHORT);
        toast3.show();
        Log.v(TAG, "Приложение было успешно перезапущено");
    }

    protected void onPause() {
        super.onPause();
        Toast toast4 = Toast.makeText(getApplicationContext(),
                "Приложение было приостановлено.", Toast.LENGTH_SHORT);
        toast4.show();
        Log.w(TAG, "Приложение было успешно приостановлено");
    }

    protected void onStop() {
        super.onStop();
        Toast toast5 = Toast.makeText(getApplicationContext(),
                "Приложение было остановлено.", Toast.LENGTH_SHORT);
        toast5.show();
        Log.d(TAG, "Приложение было успешно остановлено");
    }

    protected void onStart() {
        super.onStart();
        Toast toast6 = Toast.makeText(getApplicationContext(),
                "Приложение было запущено.", Toast.LENGTH_SHORT);
        toast6.show();
        Log.i(TAG, "Приложение было успешно запущено");
    }

    protected void onResume() {
        super.onResume();
        Toast toast7 = Toast.makeText(getApplicationContext(),
                "Приложение было возобновлено.", Toast.LENGTH_SHORT);
        toast7.show();
        Log.v(TAG, "Приложение было успешно возобновлено");
    }
}