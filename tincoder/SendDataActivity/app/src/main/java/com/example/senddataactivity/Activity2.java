package com.example.senddataactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Activity2 extends AppCompatActivity {

    private EditText edtEmail;
    private EditText edtUsername;
    private Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        getSupportActionBar().setTitle("Activity 2");

        edtEmail = findViewById(R.id.edt_email);
        edtUsername = findViewById(R.id.edt_username);
        btnUpdate = findViewById(R.id.btn_update);

        if (getIntent().getExtras() != null) {
            User user = (User) getIntent().getExtras().get("object_user");

            edtEmail.setText(user.getEmail());
            edtUsername.setText(user.getUsername());
        }

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backActivity();
            }
        });
    }

    private void backActivity() {
        String strEmailUpdate = edtEmail.getText().toString().trim();
        String strUsernameUpdate = edtUsername.getText().toString().trim();

        User user = new User(strEmailUpdate, strUsernameUpdate);

        Intent returnIntent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_user", user);
        returnIntent.putExtras(bundle);

        setResult(Activity.RESULT_OK, returnIntent);
        finish();
    }
}