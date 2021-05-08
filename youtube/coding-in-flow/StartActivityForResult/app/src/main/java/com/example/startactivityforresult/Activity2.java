package com.example.startactivityforresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private TextView textViewNumbers;
    private Button buttonAdd;
    private Button buttonSubtract;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        setTitle("Activity 2");

        textViewNumbers = findViewById(R.id.text_view_numbers);
        buttonAdd = findViewById(R.id.button_add);
        buttonSubtract = findViewById(R.id.button_subtract);

        Intent intent = getIntent();
        int number1 = intent.getIntExtra("number1_data", 0);
        int number2 = intent.getIntExtra("number2_data", 0);

        textViewNumbers.setText("Numbers: " + number1 + ", " + number2);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = number1 + number2;

                Intent resultIntent = new Intent();
                resultIntent.putExtra("result_data", result);

                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = number1 - number2;

                Intent resultIntent = new Intent();
                resultIntent.putExtra("result_data", result);

                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}