package com.example.recyclerviewmultitypeview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvUser;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvUser = findViewById(R.id.rcv_user);
        userAdapter = new UserAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvUser.setLayoutManager(linearLayoutManager);

        userAdapter.setData(getListUser());
        rcvUser.setAdapter(userAdapter);
    }

    private List<User> getListUser() {
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.yellow_bear, "User 1", true));
        list.add(new User(R.drawable.yellow_dog, "User 2", true));
        list.add(new User(R.drawable.brown_bear, "User 3", true));
        list.add(new User(R.drawable.pink_elephant, "User 4", true));
        list.add(new User(R.drawable.gray_elephant, "User 5", true));

        list.add(new User(R.drawable.yellow_bear, "User 1", false));
        list.add(new User(R.drawable.yellow_dog, "User 2", false));
        list.add(new User(R.drawable.brown_bear, "User 3", false));
        list.add(new User(R.drawable.pink_elephant, "User 4", false));
        list.add(new User(R.drawable.gray_elephant, "User 5", false));

        return list;
    }
}