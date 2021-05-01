package com.example.dragdroprecyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvItem;
    private ItemAdapter itemAdapter;
    private List<String> mListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvItem = findViewById(R.id.rcv_item);
        itemAdapter = new ItemAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvItem.setLayoutManager(linearLayoutManager);

        getDataItem();
        itemAdapter.setData(mListData);
        rcvItem.setAdapter(itemAdapter);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvItem.addItemDecoration(itemDecoration);

        ItemTouchHelper helper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN, 0) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder dragged, @NonNull RecyclerView.ViewHolder target) {
                int positionDragged = dragged.getAdapterPosition();
                int positionTarget = target.getAdapterPosition();

                Collections.swap(mListData, positionDragged, positionTarget);
                itemAdapter.notifyItemMoved(positionDragged, positionTarget);

                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            }
        });
        helper.attachToRecyclerView(rcvItem);
    }

    private void getDataItem() {
        mListData = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            mListData.add("Item " + i);
        }
    }
}