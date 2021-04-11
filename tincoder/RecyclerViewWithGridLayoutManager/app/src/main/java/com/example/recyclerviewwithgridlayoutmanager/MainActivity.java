package com.example.recyclerviewwithgridlayoutmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvUser;
    private UserAdapter mUSerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvUser = findViewById(R.id.rcv_user);
        mUSerAdapter = new UserAdapter(this);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        rcvUser.setLayoutManager(gridLayoutManager);

        mUSerAdapter.setData(getListUser());
        rcvUser.setAdapter(mUSerAdapter);
    }

    private List<User> getListUser() {
        List<User> list = new ArrayList<>();
        list.add(new User(R.mipmap.brown_bear, "brown bear"));
        list.add(new User(R.mipmap.gray_elephant, "gray elephant"));
        list.add(new User(R.mipmap.pink_elephant, "pink elephant"));

        list.add(new User(R.mipmap.brown_bear, "brown bear"));
        list.add(new User(R.mipmap.gray_elephant, "gray elephant"));
        list.add(new User(R.mipmap.pink_elephant, "pink elephant"));

        list.add(new User(R.mipmap.brown_bear, "brown bear"));
        list.add(new User(R.mipmap.gray_elephant, "gray elephant"));
        list.add(new User(R.mipmap.pink_elephant, "pink elephant"));

        list.add(new User(R.mipmap.brown_bear, "brown bear"));
        list.add(new User(R.mipmap.gray_elephant, "gray elephant"));
        list.add(new User(R.mipmap.pink_elephant, "pink elephant"));

        list.add(new User(R.mipmap.brown_bear, "brown bear"));
        list.add(new User(R.mipmap.gray_elephant, "gray elephant"));
        list.add(new User(R.mipmap.pink_elephant, "pink elephant"));

        return list;
    }
}