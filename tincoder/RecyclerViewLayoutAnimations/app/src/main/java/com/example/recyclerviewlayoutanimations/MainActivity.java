package com.example.recyclerviewlayoutanimations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rcvUser;
    private UserAdapter userAdapter;

    private Button btnLeftToRight, btnRightToLeft, btnUpToDown, btnDownToUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvUser = findViewById(R.id.rcv_user);
        userAdapter = new UserAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvUser.setLayoutManager(linearLayoutManager);

        btnLeftToRight = findViewById(R.id.btn_left_to_right);
        btnRightToLeft = findViewById(R.id.btn_right_to_left);
        btnUpToDown = findViewById(R.id.btn_up_to_down);
        btnDownToUp = findViewById(R.id.btn_down_to_up);

        btnLeftToRight.setOnClickListener(this);
        btnRightToLeft.setOnClickListener(this);
        btnUpToDown.setOnClickListener(this);
        btnDownToUp.setOnClickListener(this);
    }

    private List<User> getListUser() {
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.pink_elephant, "Pink Elephant", "NEU"));
        list.add(new User(R.drawable.gray_elephant, "Gray Elephant", "NEU"));
        list.add(new User(R.drawable.brown_bear, "Brown Bear", "NEU"));
        list.add(new User(R.drawable.yellow_bear, "Yellow Bear", "NEU"));
        list.add(new User(R.drawable.yellow_dog, "Yellow Dog", "NEU"));

        list.add(new User(R.drawable.pink_elephant, "Pink Elephant", "NEU"));
        list.add(new User(R.drawable.gray_elephant, "Gray Elephant", "NEU"));
        list.add(new User(R.drawable.brown_bear, "Brown Bear", "NEU"));
        list.add(new User(R.drawable.yellow_bear, "Yellow Bear", "NEU"));
        list.add(new User(R.drawable.yellow_dog, "Yellow Dog", "NEU"));

        list.add(new User(R.drawable.pink_elephant, "Pink Elephant", "NEU"));
        list.add(new User(R.drawable.gray_elephant, "Gray Elephant", "NEU"));
        list.add(new User(R.drawable.brown_bear, "Brown Bear", "NEU"));
        list.add(new User(R.drawable.yellow_bear, "Yellow Bear", "NEU"));
        list.add(new User(R.drawable.yellow_dog, "Yellow Dog", "NEU"));

        list.add(new User(R.drawable.pink_elephant, "Pink Elephant", "NEU"));
        list.add(new User(R.drawable.gray_elephant, "Gray Elephant", "NEU"));
        list.add(new User(R.drawable.brown_bear, "Brown Bear", "NEU"));
        list.add(new User(R.drawable.yellow_bear, "Yellow Bear", "NEU"));
        list.add(new User(R.drawable.yellow_dog, "Yellow Dog", "NEU"));

        list.add(new User(R.drawable.pink_elephant, "Pink Elephant", "NEU"));
        list.add(new User(R.drawable.gray_elephant, "Gray Elephant", "NEU"));
        list.add(new User(R.drawable.brown_bear, "Brown Bear", "NEU"));
        list.add(new User(R.drawable.yellow_bear, "Yellow Bear", "NEU"));
        list.add(new User(R.drawable.yellow_dog, "Yellow Dog", "NEU"));

        return list;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_left_to_right:
                setAnimation(R.anim.layout_animation_left_to_right);
                break;

            case R.id.btn_right_to_left:
                setAnimation(R.anim.layout_animation_right_to_left);
                break;

            case R.id.btn_up_to_down:
                break;

            case R.id.btn_down_to_up:
                break;
        }
    }

    private void setAnimation(int animResource) {
        LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(this, animResource);
        rcvUser.setLayoutAnimation(layoutAnimationController);

        userAdapter.setData(getListUser());
        rcvUser.setAdapter(userAdapter);
    }
}