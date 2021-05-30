package com.example.matchmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnCompute;
    private EditText edtYourName;
    private EditText edtOtherPersonName;
    private ImageView ivNeedle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yourName = edtYourName.getText().toString().toLowerCase().trim();
                String otherPersonName = edtOtherPersonName.getText().toString().toLowerCase().trim();

                int totalLetters = yourName.length() + otherPersonName.length();
                int totalMatches = 0;

                for (int i = 0; i < yourName.length(); i++) {
                    for (int j = 0; j < otherPersonName.length(); j++) {
                        if (yourName.charAt(i) == otherPersonName.charAt(j)) {
                            totalMatches++;
                        }
                    }
                }

                for (int i = 0; i < otherPersonName.length(); i++) {
                    for (int j = 0; j < yourName.length(); j++) {
                        if (otherPersonName.charAt(i) == yourName.charAt(j)) {
                            totalMatches++;
                        }
                    }
                }

                float compatScore = (float) totalMatches / totalLetters;

                // loveScore between -50 and 50.
                int loveScore = ((int) compatScore * 100) - 50;

                RotateAnimation ra = new RotateAnimation(0, 360 + loveScore,
                        Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                ra.setFillAfter(true);
                ra.setDuration(2000);
                ra.setInterpolator(new AccelerateDecelerateInterpolator());
                ivNeedle.setAnimation(ra);

                displayToast("Love Score of " + loveScore);
            }
        });
    }

    private void initUI() {
        btnCompute = findViewById(R.id.btn_compute);
        edtYourName = findViewById(R.id.edt_your_name);
        edtOtherPersonName = findViewById(R.id.edt_other_person_name);
        ivNeedle = findViewById(R.id.iv_needle);
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}