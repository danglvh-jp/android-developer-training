package com.example.emailauthapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    private Button btnCreateAccount;
    private Button btnLogin;
    private EditText edtLoginEmail;
    private EditText edtLoginPassword;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnCreateAccount = findViewById(R.id.btn_create_account);
        btnLogin = findViewById(R.id.btn_login);
        edtLoginEmail = findViewById(R.id.edt_login_email);
        edtLoginPassword = findViewById(R.id.edt_login_password);

        firebaseAuth = FirebaseAuth.getInstance();

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // extract / validate

                String email = edtLoginEmail.getText().toString().trim();
                String password = edtLoginPassword.getText().toString().trim();

                if (email.isEmpty()) {
                    edtLoginEmail.setError("Email is Missing.");
                    return;
                }

                if (password.isEmpty()) {
                    edtLoginPassword.setError("Password is Missing.");
                    return;
                }

                // data is valid
                // login user

                firebaseAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        // login is successful
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(Login.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
    }
}