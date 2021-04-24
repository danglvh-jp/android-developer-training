package com.example.loginapiwithretrofit.api;

import com.example.loginapiwithretrofit.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    // Link API: http://floating-eyrie-61483.herokuapp.com/api/users?fbclid=IwAR2mGMT9fafaEOwlFL6Y3j76Wl_4MSzEbC0-6tDdVu4kdpHKwjlSFpmC0_g
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    ApiService apiService = new Retrofit.Builder()
            .baseUrl("http://floating-eyrie-61483.herokuapp.com/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @GET("users")
    Call<List<User>> getListUsers(@Query("fbclid") String key);
}
