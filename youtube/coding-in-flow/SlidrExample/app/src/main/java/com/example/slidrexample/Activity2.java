package com.example.slidrexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

public class Activity2 extends AppCompatActivity {

    private SlidrInterface slidr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        slidr = Slidr.attach(this);
    }

    public void lockSlide(View view) {
        slidr.lock();
    }

    public void unlockSlide(View view) {
        slidr.unlock();
    }
}