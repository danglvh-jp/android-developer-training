package com.example.mathquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnStart;
    private Button btnAnswer0;
    private Button btnAnswer1;
    private Button btnAnswer2;
    private Button btnAnswer3;
    private TextView tvScore;
    private TextView tvQuestions;
    private TextView tvTimer;
    private TextView tvBottomMessage;
    private ProgressBar progTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btn_start);
        btnAnswer0 = findViewById(R.id.btn_answer0);
        btnAnswer1 = findViewById(R.id.btn_answer1);
        btnAnswer2 = findViewById(R.id.btn_answer2);
        btnAnswer3 = findViewById(R.id.btn_answer3);
        tvScore = findViewById(R.id.tv_score);
        tvBottomMessage = findViewById(R.id.tv_bottommessage);
        tvQuestions = findViewById(R.id.tv_questions);
        tvTimer = findViewById(R.id.tv_timer);
        progTimer = findViewById(R.id.prog_timer);

        tvTimer.setText("0Sec");
        tvQuestions.setText("");
        tvBottomMessage.setText("Press Go");
        tvScore.setText("0pts");
    }
}