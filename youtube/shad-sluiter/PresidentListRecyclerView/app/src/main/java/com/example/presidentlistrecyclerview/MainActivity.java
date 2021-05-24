package com.example.presidentlistrecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Presidents App";
    private Button btnAddOne;
    private List<President> presidentList = new ArrayList<President>();
    Menu menu;

    MyApplication myApplication = (MyApplication) this.getApplication();

    private RecyclerView rcvPres;
    private PresidentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presidentList = myApplication.getPresidentList();

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

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.sort_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_aToz:
                displayToast("Sort A to Z");
                return true;

            case R.id.menu_zToa:
                displayToast("Sort Z to A");
                return true;

            case R.id.menu_dateAscending:
                displayToast("Sort date ascending");
                return true;

            case R.id.menu_dateDescending:
                displayToast("Sort date descending");
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}