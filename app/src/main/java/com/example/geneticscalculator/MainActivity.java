package com.example.geneticscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class MainActivity extends AppCompatActivity{

    private static final String TAG = "geneticscalculator";
    public static final String KEY = "key";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(KEY, "genetics");
                startActivity(intent);
            }
        });
    }

    //public void onClick(View view) {
    //    Intent intent = new Intent(this, SecondActivity.class);
    //    startActivity(intent);
    //}

    public void Click2(View view) {
        Log.i(TAG, "Вывод log по нажатию!");
    }
}