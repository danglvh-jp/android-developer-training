package com.example.upbuttonexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        getSupportActionBar().setTitle("Activity 3");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}