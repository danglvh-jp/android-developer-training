package com.example.recyclerviewmvvmlivedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvUser;
    private Button btnAddUser;

    private UserAdapter userAdapter;
    private UserViewModel userViewModel;

    private int index = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvUser = findViewById(R.id.rcv_user);
        btnAddUser = findViewById(R.id.btn_add_user);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvUser.setLayoutManager(linearLayoutManager);

        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        userViewModel.getListUserLiveData().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                userAdapter = new UserAdapter(users);
                rcvUser.setAdapter(userAdapter);
            }
        });

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickAddUser();
            }
        });
    }

    private void clickAddUser() {
        User user = new User(R.drawable.yellow_dog, "Yellow Dog " + index, "Gau bong cho mau vang " + index);
        userViewModel.addUser(user);
        index++;
    }
}