package com.example.recyclerviewnestedscrollview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvCategory;
    private RecyclerView rcvUser;

    private CategoryAdapter categoryAdapter;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvCategory = findViewById(R.id.rcv_category);
        rcvUser = findViewById(R.id.rcv_user);

        // Category
        categoryAdapter = new CategoryAdapter();
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rcvCategory.setLayoutManager(gridLayoutManager);
        rcvCategory.setFocusable(false);
        rcvCategory.setNestedScrollingEnabled(false);

        categoryAdapter.setData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);

        // User
        userAdapter = new UserAdapter();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvUser.setLayoutManager(linearLayoutManager);
        rcvUser.setFocusable(false);
        rcvUser.setNestedScrollingEnabled(false);

        userAdapter.setData(getListUser());
        rcvUser.setAdapter(userAdapter);
    }

    private List<User> getListUser() {
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.brown_bear, "User 1"));
        list.add(new User(R.drawable.pink_elephant, "User 2"));
        list.add(new User(R.drawable.gray_elephant, "User 3"));

        list.add(new User(R.drawable.brown_bear, "User 1"));
        list.add(new User(R.drawable.pink_elephant, "User 2"));
        list.add(new User(R.drawable.gray_elephant, "User 3"));

        list.add(new User(R.drawable.brown_bear, "User 1"));
        list.add(new User(R.drawable.pink_elephant, "User 2"));
        list.add(new User(R.drawable.gray_elephant, "User 3"));

        return list;
    }

    private List<Category> getListCategory() {
        List<Category> list = new ArrayList<>();
        list.add(new Category(R.drawable.brown_bear, "Category 1"));
        list.add(new Category(R.drawable.pink_elephant, "Category 2"));
        list.add(new Category(R.drawable.gray_elephant, "Category 3"));

        list.add(new Category(R.drawable.brown_bear, "Category 1"));
        list.add(new Category(R.drawable.pink_elephant, "Category 2"));
        list.add(new Category(R.drawable.gray_elephant, "Category 3"));

        list.add(new Category(R.drawable.brown_bear, "Category 1"));
        list.add(new Category(R.drawable.pink_elephant, "Category 2"));
        list.add(new Category(R.drawable.gray_elephant, "Category 3"));

        return list;
    }
}