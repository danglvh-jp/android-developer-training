package com.example.moveviewwithanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView viewAnimation;
    private ImageView startAnimation;
    private TextView endAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewAnimation = findViewById(R.id.view_animation);
        startAnimation = findViewById(R.id.view_start_animation);
        endAnimation = findViewById(R.id.view_end_animation);

        startAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationUtil.translateAnimation(viewAnimation, startAnimation, endAnimation, new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        startAnimation.setBackgroundResource(R.drawable.bg_gray_corner_6);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        });
    }
}