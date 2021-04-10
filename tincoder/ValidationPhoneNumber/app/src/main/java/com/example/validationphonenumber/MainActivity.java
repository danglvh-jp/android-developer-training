package com.example.validationphonenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.hbb20.CountryCodePicker;

public class MainActivity extends AppCompatActivity {

    private EditText edtPhoneNumber;
    private CountryCodePicker ccp;
    private ImageView imgCheck;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtPhoneNumber = findViewById(R.id.edt_phone);
        ccp = findViewById(R.id.ccp);
        imgCheck = findViewById(R.id.img_check);

        // Attach CarrierNumber editText to CCP
        ccp.registerCarrierNumberEditText(edtPhoneNumber);

        ccp.setPhoneNumberValidityChangeListener(new CountryCodePicker.PhoneNumberValidityChangeListener() {
            @Override
            public void onValidityChanged(boolean isValidNumber) {
                if (isValidNumber) {
                    imgCheck.setImageResource(R.drawable.ic_valid);
                } else {
                    imgCheck.setImageResource(R.drawable.ic_invalid);
                }
            }
        });

        edtPhoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String input = s.toString().trim();
                if (input.length() > 0) {
                    imgCheck.setVisibility(View.VISIBLE);
                } else {
                    imgCheck.setVisibility(View.GONE);
                }
            }
        });
    }
}