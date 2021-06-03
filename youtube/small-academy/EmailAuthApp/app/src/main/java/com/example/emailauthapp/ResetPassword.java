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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ResetPassword extends AppCompatActivity {

    private Button btnSave;
    private EditText edtNewUserPassword;
    private EditText edtConfirmNewPassword;
    FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        btnSave = findViewById(R.id.btn_save);
        edtNewUserPassword = findViewById(R.id.edt_new_user_password);
        edtConfirmNewPassword = findViewById(R.id.edt_confirm_new_password);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtNewUserPassword.getText().toString().isEmpty()) {
                    edtNewUserPassword.setError("Required Field");
                    return;
                }

                if (edtConfirmNewPassword.getText().toString().trim().isEmpty()) {
                    edtConfirmNewPassword.setError("Required Field.");
                    return;
                }

                if (!edtNewUserPassword.getText().toString().equals(edtConfirmNewPassword.getText().toString().trim())) {
                    edtConfirmNewPassword.setError("Password Do not Match");
                    return;
                }

                firebaseUser.updatePassword(edtNewUserPassword.getText().toString()).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        displayToast("Password updated.");
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        displayToast(e.getMessage());
                    }
                });
            }
        });
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}