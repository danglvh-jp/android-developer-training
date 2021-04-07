package com.example.autocompletetextviewtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        String[] countries = getResources().getStringArray(R.array.countries);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, R.layout.layout_custom, R.id.tv_country_name, countries);
        autoCompleteTextView.setAdapter(arrayAdapter);
    }
}