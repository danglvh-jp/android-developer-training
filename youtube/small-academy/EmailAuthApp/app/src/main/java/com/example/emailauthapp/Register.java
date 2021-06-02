package com.example.emailauthapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private EditText edtRegisterFullName;
    private EditText edtRegisterEmail;
    private EditText edtRegisterPassword;
    private EditText edtRegisterConfPassword;
    private Button btnRegister;
    private Button btnGoToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtRegisterFullName = findViewById(R.id.edt_register_full_name);
        edtRegisterEmail = findViewById(R.id.edt_register_email);
        edtRegisterPassword = findViewById(R.id.edt_register_password);
        edtRegisterConfPassword = findViewById(R.id.edt_register_conf_password);
        btnRegister = findViewById(R.id.btn_register);
        btnGoToLogin = findViewById(R.id.btn_go_to_login);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // extract the data from the form

                String fullName = edtRegisterFullName.getText().toString().trim();
                String email = edtRegisterEmail.getText().toString().trim();
                String password = edtRegisterPassword.getText().toString().trim();
                String confPassword = edtRegisterConfPassword.getText().toString().trim();

                if (fullName.isEmpty()) {
                    edtRegisterFullName.setError("Full name is Required");
                    return;
                }

                if (email.isEmpty()) {
                    edtRegisterEmail.setError("Email is Required");
                    return;
                }
                if (password.isEmpty()) {
                    edtRegisterPassword.setError("Password is Required");
                    return;
                }

                if (confPassword.isEmpty()) {
                    edtRegisterConfPassword.setError("Confirm Password is Required");
                    return;
                }

                if (!password.equals(confPassword)) {
                    edtRegisterConfPassword.setError("Password Do not Match.");
                    return;
                }

                // data is validated
                // register the user using firebase

                displayToast("Data Validated.");
            }
        });
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}