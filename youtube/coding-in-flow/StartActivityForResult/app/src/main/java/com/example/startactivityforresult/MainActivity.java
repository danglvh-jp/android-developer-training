package com.example.startactivityforresult;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mTextViewResult;
    private EditText mEditTextNumber1;
    private EditText mEditTextNumber2;
    private Button buttonOpenActivity2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextViewResult = findViewById(R.id.text_view_result);
        mEditTextNumber1 = findViewById(R.id.edit_text_number1);
        mEditTextNumber2 = findViewById(R.id.edit_text_number2);

        buttonOpenActivity2 = findViewById(R.id.button_open_activity2);
        buttonOpenActivity2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((mEditTextNumber1.getText().toString().equals(""))
                        || (mEditTextNumber2.getText().toString().equals(""))) {
                    displayToast("Please insert numbers");
                } else {

                    int number1 = Integer.parseInt(mEditTextNumber1.getText().toString());
                    int number2 = Integer.parseInt(mEditTextNumber2.getText().toString());

                    Intent intent = new Intent(MainActivity.this, Activity2.class);
                    intent.putExtra("number1_data", number1);
                    intent.putExtra("number2_data", number2);
                    startActivityForResult(intent, 1);
                }
            }
        });
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                int result = data.getIntExtra("result_data", 0);
                mTextViewResult.setText("" + result);
            }
            if (resultCode == RESULT_CANCELED) {
                mTextViewResult.setText("Nothing selected");
            }
        }
    }
}