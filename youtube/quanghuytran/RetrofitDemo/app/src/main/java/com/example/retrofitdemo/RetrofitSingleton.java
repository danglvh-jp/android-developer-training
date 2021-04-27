package com.example.retrofitdemo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {

    private static final RetrofitSingleton ourInstance = new RetrofitSingleton();
    private Retrofit mRetrofit;

    static RetrofitSingleton getInstance() {
        return ourInstance;
    }

    private RetrofitSingleton() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public Retrofit getRetrofit() {
        return mRetrofit;
    }
}
