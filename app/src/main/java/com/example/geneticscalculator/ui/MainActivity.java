package com.example.geneticscalculator.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.geneticscalculator.R;

public class MainActivity extends AppCompatActivity{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .setReorderingAllowed(true)
//                    .add(R.id.fragment_container, HomeFragment.class, null)
//                    .commit();
//        }
    }
}