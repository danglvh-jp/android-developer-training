package com.example.retrofitdemo;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

public class Photo {
    @SerializedName("title")
    private String title;
    @SerializedName("url")
    private String url;

    public Photo(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    @NonNull
    @Override
    public String toString() {
        return title;
    }
}
