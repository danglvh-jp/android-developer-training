package com.example.myvideoslibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvVideoList;
    private VideoAdapter videoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvVideoList = findViewById(R.id.rcv_video_list);
        rcvVideoList.setLayoutManager(new LinearLayoutManager(this));
        videoAdapter = new VideoAdapter();
        rcvVideoList.setAdapter(videoAdapter);
    }
}