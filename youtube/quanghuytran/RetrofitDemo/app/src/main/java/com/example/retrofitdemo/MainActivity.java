package com.example.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private ImageView mImagePhoto;
    private EditText mEditNumber;
    private Button mButtonLoad;
    private TextView mTextContent;

    private static final String TAG = "MainActivity";

    private List<Photo> mPhotos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImagePhoto = findViewById(R.id.image_photo);
        mEditNumber = findViewById(R.id.edit_number);
        mButtonLoad = findViewById(R.id.button_load);
        mTextContent = findViewById(R.id.text_content);

        loadPhotos();
        mButtonLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPhoto();
            }
        });
    }

    private void loadPhotos() {
        Retrofit retrofit = RetrofitSingleton.getInstance().getRetrofit();
        IPhotoNetwork iPhotoNetwork = retrofit.create(IPhotoNetwork.class);
        iPhotoNetwork.getPhotos()
                .enqueue(new Callback<List<Photo>>() {
                    @Override
                    public void onResponse(Call<List<Photo>> call, Response<List<Photo>> response) {
                        Log.d(TAG, "onResponse: " + response.body());
                        mPhotos.addAll(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<Photo>> call, Throwable t) {
                        displayToast(t.getMessage());
                    }
                });

    }

    private void showPhoto() {
        String input = mEditNumber.getText().toString();
        if (input.length() > 0) {
            int position = Integer.parseInt(input) - 1;
            if ((position >= 0) && (position < mPhotos.size())) {
                Photo photo = mPhotos.get(position);
                Picasso.get().load(photo.getUrl()).into(mImagePhoto);
                mTextContent.setText(photo.getTitle());
            }
        }
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}