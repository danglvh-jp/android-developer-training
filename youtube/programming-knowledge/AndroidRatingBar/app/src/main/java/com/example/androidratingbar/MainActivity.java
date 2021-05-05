package com.example.androidratingbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static Button button_sbm;
    private static TextView text_v;
    private static RatingBar rating_b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listenerForRatingBar();
        onButtonClickListener();
    }

    public void listenerForRatingBar() {
        rating_b = findViewById(R.id.ratingBar);
        text_v = findViewById(R.id.textView);

        rating_b.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                text_v.setText(String.valueOf(rating));
            }
        });
    }

    private void onButtonClickListener() {
        rating_b = findViewById(R.id.ratingBar);
        button_sbm = findViewById(R.id.button);

        button_sbm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayToast(String.valueOf(rating_b.getRating()));
            }
        });
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}