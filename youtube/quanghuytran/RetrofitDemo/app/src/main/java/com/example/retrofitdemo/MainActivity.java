package com.example.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView mImagePhoto;
    private EditText mEditNumber;
    private Button mButtonLoad;
    private TextView mTextContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImagePhoto = findViewById(R.id.image_photo);
        mEditNumber = findViewById(R.id.edit_number);
        mButtonLoad = findViewById(R.id.button_load);
        mTextContent = findViewById(R.id.text_content);

        loadPhoto();
        mButtonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPhoto();
            }
        });
    }

    private void loadPhoto() {
    }

    private void showPhoto() {
    }
}