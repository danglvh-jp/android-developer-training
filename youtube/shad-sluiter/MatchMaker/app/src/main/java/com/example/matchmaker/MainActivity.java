package com.example.matchmaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnCompute;
    private EditText edtYourName;
    private EditText edtOtherPersonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        btnCompute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String yourName = edtYourName.getText().toString().trim();
                String otherPersonName = edtOtherPersonName.getText().toString().trim();

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

                float compatScore = totalMatches / totalLetters;
                displayToast("Compat Score = " + compatScore);
            }
        });
    }

    private void initUI() {
        btnCompute = findViewById(R.id.btn_compute);
        edtYourName = findViewById(R.id.edt_your_name);
        edtOtherPersonName = findViewById(R.id.edt_other_person_name);
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}