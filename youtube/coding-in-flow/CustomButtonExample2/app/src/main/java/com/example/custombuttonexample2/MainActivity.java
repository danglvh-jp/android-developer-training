package com.example.custombuttonexample2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button customButton;
    private Switch switchEnableButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        customButton = findViewById(R.id.custom_button);
        switchEnableButton = findViewById(R.id.switch_enable_button);

        customButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayToast("Click");
            }
        });

        switchEnableButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    customButton.setEnabled(true);
                } else {
                    customButton.setEnabled(false);
                }
            }
        });
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}