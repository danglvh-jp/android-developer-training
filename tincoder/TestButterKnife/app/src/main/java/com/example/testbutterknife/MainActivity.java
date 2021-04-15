package com.example.testbutterknife;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_1)
    Button btn1;

    @BindView(R.id.btn_2)
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Init
        ButterKnife.bind(this);

        // Set text
        setTextButton();

    }

    private void setTextButton() {
        btn1.setText("Lap trinh Android");
        btn2.setText("Hai Dang");
    }

    @OnClick({R.id.btn_1, R.id.btn_2})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                displayToast("Click Button 1");
                break;
            case R.id.btn_2:
                displayToast("Click Button 2");
        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
}