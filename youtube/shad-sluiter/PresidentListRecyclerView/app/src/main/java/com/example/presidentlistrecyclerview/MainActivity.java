package com.example.presidentlistrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Presidents App";
    private Button btnAddOne;
    private List<President> presidentList = new ArrayList<President>();

    private RecyclerView rcvPres;
    private PresidentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillPresidentList();
        Log.d(TAG, "onCreate:" + presidentList.toString());
        displayToast("Presidents count = " + presidentList.size());

        btnAddOne = findViewById(R.id.btn_addOne);
        rcvPres = findViewById(R.id.lv_presidentList);

        btnAddOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddEditOne.class);
                startActivity(intent);
            }
        });

        rcvPres.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvPres.setLayoutManager(linearLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new PresidentAdapter(presidentList, MainActivity.this);
        rcvPres.setAdapter(mAdapter);
    }

    private void fillPresidentList() {
        presidentList.add(new President(0, "George Washington", 1788, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg/160px-Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg"));
        presidentList.add(new President(1, "John Adams", 1796, "https://upload.wikimedia.org/wikipedia/commons/thumb/7/70/John_Adams%2C_Gilbert_Stuart%2C_c1800_1815.jpg/160px-John_Adams%2C_Gilbert_Stuart%2C_c1800_1815.jpg"));
        presidentList.add(new President(2, "Thomas Jefferson", 1800, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1e/Thomas_Jefferson_by_Rembrandt_Peale%2C_1800.jpg/160px-Thomas_Jefferson_by_Rembrandt_Peale%2C_1800.jpg"));
        presidentList.add(new President(3, "James Madison", 1808, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1d/James_Madison.jpg/160px-James_Madison.jpg"));
        presidentList.add(new President(4, "James Monroe", 1816, "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/James_Monroe_White_House_portrait_1819.jpg/160px-James_Monroe_White_House_portrait_1819.jpg"));
        presidentList.add(new President(5, "John Quincy Adams", 1824, "https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/JQA_Photo.tif/lossy-page1-160px-JQA_Photo.tif.jpg"));
        presidentList.add(new President(6, "Andrew Jackson", 1828, "https://upload.wikimedia.org/wikipedia/commons/thumb/4/43/Andrew_jackson_head.jpg/165px-Andrew_jackson_head.jpg"));
        presidentList.add(new President(7, "Martin Van Buren", 1836, "https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/Martin_Van_Buren_edit.jpg/160px-Martin_Van_Buren_edit.jpg"));
        presidentList.add(new President(8, "William Henry Harrison", 1840, "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c5/William_Henry_Harrison_daguerreotype_edit.jpg/160px-William_Henry_Harrison_daguerreotype_edit.jpg"));
        presidentList.add(new President(9, "John Tyler", 1840, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1d/John_Tyler%2C_Jr.jpg/160px-John_Tyler%2C_Jr.jpg"));
        presidentList.add(new President(10, "James K. Polk", 1844, "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/JKP.jpg/160px-JKP.jpg"));
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}