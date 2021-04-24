package com.example.loginapiwithretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginapiwithretrofit.api.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUserName;
    private EditText edtPassword;
    private Button btnLogin;

    private List<User> mListUser;
    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUserName = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);

        mListUser = new ArrayList<>();
        getListUsers();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickLogin();
            }
        });
    }

    private void clickLogin() {
        String strUsername = edtUserName.getText().toString().trim();
        String strPassword = edtPassword.getText().toString().trim();

        if (mListUser == null || mListUser.isEmpty()) {
            return;
        }

        boolean isHasUser = false;
        for (User user : mListUser) {
            if (strUsername.equals(user.getUserName()) && strPassword.equals(user.getUserPassword())) {
                isHasUser = true;
                mUser = user;
                break;
            }
        }

        if (isHasUser) {
            // MainActivity
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("object_user", mUser);
            intent.putExtras(bundle);
            startActivity(intent);
        } else {
            displayToast("Username or password invalid");
        }
    }

    private void getListUsers() {
        ApiService.apiService.getListUsers("IwAR2mGMT9fafaEOwlFL6Y3j76Wl_4MSzEbC0-6tDdVu4kdpHKwjlSFpmC0_g")
                .enqueue(new Callback<List<User>>() {
                    @Override
                    public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                        mListUser = response.body();
                        Log.e("List Users", mListUser.size() + "");
                    }

                    @Override
                    public void onFailure(Call<List<User>> call, Throwable t) {
                        displayToast("Call api error");
                    }
                });
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}