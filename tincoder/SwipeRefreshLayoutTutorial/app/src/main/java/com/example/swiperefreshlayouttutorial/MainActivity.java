package com.example.swiperefreshlayouttutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView rcvData;
    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvData = findViewById(R.id.rcv_data);
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvData.setLayoutManager(linearLayoutManager);

        itemAdapter = new ItemAdapter();
        itemAdapter.setData(getListItems());
        rcvData.setAdapter(itemAdapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvData.addItemDecoration(itemDecoration);

        swipeRefreshLayout.setOnRefreshListener(this);
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.design_default_color_primary));
    }

    private List<ItemObject> getListItems() {
        List<ItemObject> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new ItemObject("Item " + i));
        }
        return list;
    }

    @Override
    public void onRefresh() {
        itemAdapter.setData(getListItems());
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
            }
        }, 3000);
    }
}