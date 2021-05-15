package com.example.senddataactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private static final int MY_REQUEST_CODE = 10;
    private EditText edtEmail;
    private EditText edtUsername;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Activity 1");

        edtEmail = findViewById(R.id.edt_email);
        edtUsername = findViewById(R.id.edt_username);
        btnSend = findViewById(R.id.btn_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity();
            }
        });
    }

    private void nextActivity() {
        String strEmail = edtEmail.getText().toString().trim();
        String strUsername = edtUsername.getText().toString().trim();

        User user = new User(strEmail, strUsername);

        Intent intent = new Intent(MainActivity.this, Activity2.class);

        Bundle bundle = new Bundle();
        bundle.putSerializable("object_user", user);

        intent.putExtras(bundle);

        startActivityForResult(intent, MY_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (MY_REQUEST_CODE == requestCode) {
            if (resultCode == Activity.RESULT_OK) {
                User user = (User) data.getExtras().get("object_user");
                edtEmail.setText(user.getEmail());
                edtUsername.setText(user.getUsername());
            }
        }
    }
}