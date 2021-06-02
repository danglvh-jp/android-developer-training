package com.example.otpauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.PhoneAuthCredential;

public class Authentication extends AppCompatActivity {

    private Button btnSendOTP;
    private EditText edtCountryCode;
    private EditText edtPhoneNumber;
    private Button btnVerify;
    private Button btnResendOTP;
    private EditText edtEnterOTPField;

    String userPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);

        btnSendOTP = findViewById(R.id.btn_send_otp);
        edtCountryCode = findViewById(R.id.edt_country_code);
        edtPhoneNumber = findViewById(R.id.edt_phone_number);
        edtEnterOTPField = findViewById(R.id.edt_enter_otp_field);
        btnVerify = findViewById(R.id.btn_verify);
        btnResendOTP = findViewById(R.id.btn_resend_otp);

        btnSendOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtCountryCode.getText().toString().isEmpty()) {
                    edtCountryCode.setError("Required");
                    return;
                }

                if (edtPhoneNumber.getText().toString().isEmpty()) {
                    edtPhoneNumber.setError("Phone Number Is Required.");
                    return;
                }

                userPhoneNumber = "+" + edtCountryCode.getText().toString() + edtPhoneNumber.getText().toString();

                displayToast(userPhoneNumber);
            }
        });
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void verifyPhoneNumber(String phoneNum) {
    }

    public void authenticateUser(PhoneAuthCredential credential) {
    }
}