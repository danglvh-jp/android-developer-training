package com.example.emailauthapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private Button btnLogout;
    private Button btnVerifyEmailNow;
    private TextView tvVerifyEmailMsg;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firebaseAuth = FirebaseAuth.getInstance();

        btnLogout = findViewById(R.id.btn_logout);
        btnVerifyEmailNow = findViewById(R.id.btn_verify_email_now);
        tvVerifyEmailMsg = findViewById(R.id.tv_verify_email_msg);

        if (!firebaseAuth.getCurrentUser().isEmailVerified()) {
            tvVerifyEmailMsg.setVisibility(View.VISIBLE);
            btnVerifyEmailNow.setVisibility(View.VISIBLE);
        }

        btnVerifyEmailNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // send verification email
                firebaseAuth.getCurrentUser().sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        displayToast("Verification Email Sent.");
                        tvVerifyEmailMsg.setVisibility(View.GONE);
                        btnVerifyEmailNow.setVisibility(View.GONE);
                    }
                });
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
            }
        });
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.resetUserPassword) {
            startActivity(new Intent(getApplicationContext(), ResetPassword.class));
        }

        return super.onOptionsItemSelected(item);
    }
}