package com.example.bottomsheetandrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnOpenBottomSheet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOpenBottomSheet = findViewById(R.id.btn_open_bottom_sheet);
        btnOpenBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickOpenBottomSheetFragment();
            }
        });
    }

    private void clickOpenBottomSheetFragment() {
        List<ItemObject> list = new ArrayList<>();
        list.add(new ItemObject("Item 1"));
        list.add(new ItemObject("Item 2"));
        list.add(new ItemObject("Item 3"));
        list.add(new ItemObject("Item 4"));
        list.add(new ItemObject("Item 5"));

        MyBottomSheetFragment myBottomSheetFragment = new MyBottomSheetFragment(list, new IClickListener() {
            @Override
            public void clickItem(ItemObject itemObject) {
                displayToast(itemObject.getName());
            }
        });
        myBottomSheetFragment.show(getSupportFragmentManager(), myBottomSheetFragment.getTag());
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}