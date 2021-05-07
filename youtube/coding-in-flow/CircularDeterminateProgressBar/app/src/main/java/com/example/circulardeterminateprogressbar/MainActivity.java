package com.example.circulardeterminateprogressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button_incr, button_decr;
    private ProgressBar progress_bar;
    private TextView text_view_progress;
    private int progr = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_incr = findViewById(R.id.button_incr);
        button_decr = findViewById(R.id.button_decr);

        updateProgressBar();

        button_incr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (progr <= 90) {
                    progr += 10;
                    updateProgressBar();
                }
            }
        });

        button_decr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (progr >= 10) {
                    progr -= 10;
                    updateProgressBar();
                }
            }
        });
    }

    private void updateProgressBar() {
        progress_bar = findViewById(R.id.progress_bar);
        progress_bar.setProgress(progr);

        text_view_progress = findViewById(R.id.text_view_progress);
        text_view_progress.setText(String.valueOf(progr));
    }
}