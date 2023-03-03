package com.example.geneticscalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SecondActivity extends AppCompatActivity{
    private static final String TAG = "SecondActivity";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        parseArgs();
        ImageButton imageButton = findViewById(R.id.buttonBack);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }

    private void parseArgs() {
        String arg1 = getIntent().getStringExtra(MainActivity.KEY);
        Log.d(TAG, arg1);
    }
}