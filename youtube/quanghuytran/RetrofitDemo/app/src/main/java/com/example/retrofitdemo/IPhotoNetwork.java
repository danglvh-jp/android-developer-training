package com.example.retrofitdemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IPhotoNetwork {
    @GET("albums/1/photos")
    Call<List<Photo>> getPhotos();
}
