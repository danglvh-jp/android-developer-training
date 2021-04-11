package com.example.recyclerviewfloatingactionbutton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcv_user;
    private FloatingActionButton btnFloating;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcv_user = findViewById(R.id.rcv_user);
        btnFloating = findViewById(R.id.btn_floating);

        userAdapter = new UserAdapter(getApplicationContext());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcv_user.setLayoutManager(linearLayoutManager);

        userAdapter.setData(getListUser());
        rcv_user.setAdapter(userAdapter);

        rcv_user.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) {
                    btnFloating.hide();
                } else {
                    btnFloating.show();
                }
                super.onScrolled(recyclerView, dx, dy);
            }
        });
    }

    public List<User> getListUser() {
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