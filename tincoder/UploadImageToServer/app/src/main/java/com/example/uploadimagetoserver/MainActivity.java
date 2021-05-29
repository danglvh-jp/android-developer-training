package com.example.uploadimagetoserver;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.uploadimagetoserver.api.ApiService;
import com.example.uploadimagetoserver.api.Const;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final int MY_REQUEST_CODE = 10;
    private static final String TAG = MainActivity.class.getName();
    private EditText edtUsername;
    private EditText edtPassword;
    private TextView tvUsername;
    private TextView tvPassword;
    private ImageView imgFromGallery;
    private ImageView imgFromApi;
    private Button btnSelectImage;
    private Button btnUploadImage;
    private Uri mUri;
    private ProgressDialog mProgressDialog;

    private ActivityResultLauncher<Intent> mActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Log.e(TAG, "onActivityResult");
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // There are no request codes
                        Intent data = result.getData();
                        if (data == null) {
                            return;
                        }
                        Uri uri = data.getData();
                        mUri = uri;
                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                            imgFromGallery.setImageBitmap(bitmap);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        // doSomeOperations();
                    }
                }
            });

    private void initUI() {
        edtUsername = findViewById(R.id.edt_username);
        edtPassword = findViewById(R.id.edt_password);
        tvUsername = findViewById(R.id.tv_username);
        tvPassword = findViewById(R.id.tv_password);
        imgFromApi = findViewById(R.id.img_from_api);
        imgFromGallery = findViewById(R.id.img_from_gallery);
        btnSelectImage = findViewById(R.id.btn_select_image);
        btnUploadImage = findViewById(R.id.btn_upload_image);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        // Init progress dialog
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Please wait ...");

        btnSelectImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickRequestPermission();
            }
        });

        btnUploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mUri != null) {
                    callApiRegisterAccount();
                }
            }
        });

    }

    private void onClickRequestPermission() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            openGallery();
            return;
        }

        if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            openGallery();
        } else {
            String[] permission = {
                    Manifest.permission.READ_EXTERNAL_STORAGE
            };
            requestPermissions(permission, MY_REQUEST_CODE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull @org.jetbrains.annotations.NotNull String[] permissions, @NonNull @org.jetbrains.annotations.NotNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == MY_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openGallery();
            }
        }

    }

    private void openGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        mActivityResultLauncher.launch(Intent.createChooser(intent, "Select Image"));
    }

    private void callApiRegisterAccount() {
        mProgressDialog.show();

        String strUsername = edtUsername.getText().toString().trim();
        String strPassword = edtPassword.getText().toString().trim();

        RequestBody requestBodyUsername = RequestBody.create(MediaType.parse("multipart/form-data"), strUsername);
        RequestBody requestBodyPassword = RequestBody.create(MediaType.parse("multipart/form-data"), strPassword);

        String strRealPath = RealPathUtil.getRealPath(this, mUri);
        Log.e("Tincoder", strRealPath);
        File file = new File(strRealPath);
        RequestBody requestBodyAvt = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part multipartBodyAvt = MultipartBody.Part.createFormData(Const.KEY_AVT, file.getName(), requestBodyAvt);

        ApiService.apiService.registerAccount(requestBodyUsername, requestBodyPassword, multipartBodyAvt).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                mProgressDialog.dismiss();
                User user = response.body();
                if (user != null) {
                    tvUsername.setText(user.getUsername());
                    tvPassword.setText(user.getPassword());
                    Glide.with(MainActivity.this).load(user.getAvatar()).into(imgFromApi);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                mProgressDialog.dismiss();
                displayToast("Call api fail");
            }
        });
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}