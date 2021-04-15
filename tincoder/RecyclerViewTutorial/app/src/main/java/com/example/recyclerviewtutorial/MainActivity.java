package com.example.recyclerviewtutorial;

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
        userAdapter = new UserAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvUser.setLayoutManager(linearLayoutManager);

        userAdapter.setData(getListUser());
        rcvUser.setAdapter(userAdapter);
    }

    private List<User> getListUser() {
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.pink_elephant, "pink elephant"));
        list.add(new User(R.drawable.brown_bear, "brown bear"));
        list.add(new User(R.drawable.gray_elephant, "gray elephant"));

        list.add(new User(R.drawable.pink_elephant, "pink elephant"));
        list.add(new User(R.drawable.brown_bear, "brown bear"));
        list.add(new User(R.drawable.gray_elephant, "gray elephant"));

        list.add(new User(R.drawable.pink_elephant, "pink elephant"));
        list.add(new User(R.drawable.brown_bear, "brown bear"));
        list.add(new User(R.drawable.gray_elephant, "gray elephant"));

        list.add(new User(R.drawable.pink_elephant, "pink elephant"));
        list.add(new User(R.drawable.brown_bear, "brown bear"));
        list.add(new User(R.drawable.gray_elephant, "gray elephant"));

        return list;
    }
}