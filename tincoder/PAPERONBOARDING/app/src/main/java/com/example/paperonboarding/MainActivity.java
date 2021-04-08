package com.example.paperonboarding;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.ramotion.paperonboarding.PaperOnboardingEngine;
import com.ramotion.paperonboarding.PaperOnboardingPage;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnChangeListener;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnLeftOutListener;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding_main_layout);

        PaperOnboardingEngine engine = new PaperOnboardingEngine(findViewById(R.id.onboardingRootView),
                getPaperOnboardingPageData(),
                this);

        engine.setOnChangeListener(new PaperOnboardingOnChangeListener() {
            @Override
            public void onPageChanged(int i, int i1) {
                displayToast("Swiped from " + i + " to " + i1);
            }
        });

        engine.setOnRightOutListener(new PaperOnboardingOnRightOutListener() {
            @Override
            public void onRightOut() {
                displayToast("Swiped out right");
            }
        });

        engine.setOnLeftOutListener(new PaperOnboardingOnLeftOutListener() {
            @Override
            public void onLeftOut() {
                displayToast("Swiped out left");
            }
        });
    }

    private ArrayList<PaperOnboardingPage> getPaperOnboardingPageData() {
        PaperOnboardingPage scr1 = new PaperOnboardingPage("Hotels",
                "All hotels and hostels are sorted by hospitality rating",
                Color.parseColor("#678FB4"), R.drawable.hotels, R.drawable.key);
        PaperOnboardingPage scr2 = new PaperOnboardingPage("Banks",
                "We carefully verify all banks before add them into the app",
                Color.parseColor("#65B0B4"), R.drawable.banks, R.drawable.wallet);
        PaperOnboardingPage scr3 = new PaperOnboardingPage("Stores",
                "All local stores are categorized for your convenience",
                Color.parseColor("#9B90BC"), R.drawable.stores, R.drawable.shopping_cart);

        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();
        elements.add(scr1);
        elements.add(scr2);
        elements.add(scr3);

        return elements;
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}