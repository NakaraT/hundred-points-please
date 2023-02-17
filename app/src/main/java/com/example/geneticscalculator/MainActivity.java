package com.example.geneticscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toast toast1 = Toast.makeText(getApplicationContext(),
                "Приложение создано.", Toast.LENGTH_SHORT);
        toast1.show();
        setContentView(R.layout.activity_main);
    }

    protected void onDestroy() {
        super.onDestroy();
        Toast toast2 = Toast.makeText(getApplicationContext(),
                "Приложение закрыто.", Toast.LENGTH_SHORT);
        toast2.show();

    }

    protected void onRestart() {
        super.onRestart();
        Toast toast3 = Toast.makeText(getApplicationContext(),
                "Приложение перезапущено.", Toast.LENGTH_SHORT);
        toast3.show();
    }

    protected void onPause() {
        super.onPause();
        Toast toast4 = Toast.makeText(getApplicationContext(),
                "Приложение было приостановлено.", Toast.LENGTH_SHORT);
        toast4.show();
    }

    protected void onStop() {
        super.onStop();
        Toast toast5 = Toast.makeText(getApplicationContext(),
                "Приложение было остановлено.", Toast.LENGTH_SHORT);
        toast5.show();
    }

    protected void onStart() {
        super.onStart();
        Toast toast6 = Toast.makeText(getApplicationContext(),
                "Приложение было запущено.", Toast.LENGTH_SHORT);
        toast6.show();
    }

    protected void onResume() {
        super.onResume();
        Toast toast7 = Toast.makeText(getApplicationContext(),
                "Приложение было возобновлено.", Toast.LENGTH_SHORT);
        toast7.show();
    }
}