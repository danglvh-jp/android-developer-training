package com.example.maskedittext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.santalu.maskedittext.MaskEditText;

public class MainActivity extends AppCompatActivity {

    private MaskEditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void showText(View v) {
        Toast.makeText(getApplicationContext(), editText.getText(), Toast.LENGTH_SHORT).show();
    }

    private void showRawText(View v) {
        Toast.makeText(getApplicationContext(), editText.getRawText(), Toast.LENGTH_SHORT).show();
    }
}