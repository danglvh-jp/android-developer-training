package com.example.viewpager2androidtutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.icu.lang.UCharacter;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;
    private RadioGroup radioGroup3;
    private ViewPager2Adapter viewPager2Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager2 = findViewById(R.id.viewpager2);
        radioGroup1 = findViewById(R.id.radio_group_1);
        radioGroup2 = findViewById(R.id.radio_group_2);
        radioGroup3 = findViewById(R.id.radio_group_3);

        radioGroup1.check(R.id.rdb_ltr);
        radioGroup2.check(R.id.rdb_horizontal);
        radioGroup3.check(R.id.rdb_normal);

        viewPager2Adapter = new ViewPager2Adapter(this);
        viewPager2.setAdapter(viewPager2Adapter);

        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rdb_ltr:
                        viewPager2.setLayoutDirection(View.LAYOUT_DIRECTION_LTR);
                        break;

                    case R.id.rdb_rtl:
                        viewPager2.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
                        break;
                }
            }
        });

        radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rdb_vertical:
                        viewPager2.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
                        break;

                    case R.id.rdb_horizontal:
                        viewPager2.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
                        break;
                }
            }
        });

        radioGroup3.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rdb_normal:
                        viewPager2.setPageTransformer(null);
                        break;

                    case R.id.rdb_zoom:
                        viewPager2.setPageTransformer(new ZoomOutPageTransformer());
                        break;

                    case R.id.rdb_depth:
                        viewPager2.setPageTransformer(new DepthPageTransformer());
                        break;
                }
            }
        });
    }
}