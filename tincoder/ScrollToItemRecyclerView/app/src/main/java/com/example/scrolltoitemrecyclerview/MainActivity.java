package com.example.scrolltoitemrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rcvFood;
    private Button btnCafe, btnTraSua, btnSuaChua;
    private FoodAdapter foodAdapter;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCafe = findViewById(R.id.btn_cafe);
        btnTraSua = findViewById(R.id.btn_trasua);
        btnSuaChua = findViewById(R.id.btn_suachua);

        rcvFood = findViewById(R.id.rcv_food);
        gridLayoutManager = new GridLayoutManager(this, 2);
        rcvFood.setLayoutManager(gridLayoutManager);

        foodAdapter = new FoodAdapter(getListFood());
        rcvFood.setAdapter(foodAdapter);

        btnCafe.setOnClickListener(this);
        btnTraSua.setOnClickListener(this);
        btnSuaChua.setOnClickListener(this);
    }

    private List<Food> getListFood() {
        List<Food> list = new ArrayList<>();
        list.add(new Food(R.drawable.ic_cafe, "Cafe", Food.TYPE_CAFE));
        list.add(new Food(R.drawable.ic_cafe, "Cafe", Food.TYPE_CAFE));
        list.add(new Food(R.drawable.ic_cafe, "Cafe", Food.TYPE_CAFE));
        list.add(new Food(R.drawable.ic_cafe, "Cafe", Food.TYPE_CAFE));
        list.add(new Food(R.drawable.ic_cafe, "Cafe", Food.TYPE_CAFE));
        list.add(new Food(R.drawable.ic_cafe, "Cafe", Food.TYPE_CAFE));
        list.add(new Food(R.drawable.ic_cafe, "Cafe", Food.TYPE_CAFE));
        list.add(new Food(R.drawable.ic_cafe, "Cafe", Food.TYPE_CAFE));
        list.add(new Food(R.drawable.ic_cafe, "Cafe", Food.TYPE_CAFE));
        list.add(new Food(R.drawable.ic_cafe, "Cafe", Food.TYPE_CAFE));

        list.add(new Food(R.drawable.ic_trasua, "Tra sua", Food.TYPE_TRA_SUA));
        list.add(new Food(R.drawable.ic_trasua, "Tra sua", Food.TYPE_TRA_SUA));
        list.add(new Food(R.drawable.ic_trasua, "Tra sua", Food.TYPE_TRA_SUA));
        list.add(new Food(R.drawable.ic_trasua, "Tra sua", Food.TYPE_TRA_SUA));
        list.add(new Food(R.drawable.ic_trasua, "Tra sua", Food.TYPE_TRA_SUA));
        list.add(new Food(R.drawable.ic_trasua, "Tra sua", Food.TYPE_TRA_SUA));
        list.add(new Food(R.drawable.ic_trasua, "Tra sua", Food.TYPE_TRA_SUA));
        list.add(new Food(R.drawable.ic_trasua, "Tra sua", Food.TYPE_TRA_SUA));
        list.add(new Food(R.drawable.ic_trasua, "Tra sua", Food.TYPE_TRA_SUA));
        list.add(new Food(R.drawable.ic_trasua, "Tra sua", Food.TYPE_TRA_SUA));

        list.add(new Food(R.drawable.ic_suachua, "Sua chua", Food.TYPE_SUA_CHUA));
        list.add(new Food(R.drawable.ic_suachua, "Sua chua", Food.TYPE_SUA_CHUA));
        list.add(new Food(R.drawable.ic_suachua, "Sua chua", Food.TYPE_SUA_CHUA));
        list.add(new Food(R.drawable.ic_suachua, "Sua chua", Food.TYPE_SUA_CHUA));
        list.add(new Food(R.drawable.ic_suachua, "Sua chua", Food.TYPE_SUA_CHUA));
        list.add(new Food(R.drawable.ic_suachua, "Sua chua", Food.TYPE_SUA_CHUA));
        list.add(new Food(R.drawable.ic_suachua, "Sua chua", Food.TYPE_SUA_CHUA));
        list.add(new Food(R.drawable.ic_suachua, "Sua chua", Food.TYPE_SUA_CHUA));
        list.add(new Food(R.drawable.ic_suachua, "Sua chua", Food.TYPE_SUA_CHUA));
        list.add(new Food(R.drawable.ic_suachua, "Sua chua", Food.TYPE_SUA_CHUA));
        return list;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_cafe:
                scrollToItem(0);
                break;

            case R.id.btn_trasua:
                scrollToItem(10);
                break;

            case R.id.btn_suachua:
                scrollToItem(20);
                break;
        }
    }

    private void scrollToItem(int index) {
        if (gridLayoutManager == null) {
            return;
        }
        gridLayoutManager.scrollToPositionWithOffset(index, 0);
    }
}