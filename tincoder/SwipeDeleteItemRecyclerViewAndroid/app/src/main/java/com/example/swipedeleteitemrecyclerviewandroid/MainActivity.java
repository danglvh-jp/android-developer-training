package com.example.swipedeleteitemrecyclerviewandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvItem;
    private ItemAdapter itemAdapter;
    private List<ItemObject> mListItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvItem = findViewById(R.id.rcv_item);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvItem.setLayoutManager(linearLayoutManager);

        itemAdapter = new ItemAdapter();
        mListItems = getListItems();
        itemAdapter.setData(mListItems);
        rcvItem.setAdapter(itemAdapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvItem.addItemDecoration(itemDecoration);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                mListItems.remove(position);
                itemAdapter.notifyDataSetChanged();
            }
        });
        itemTouchHelper.attachToRecyclerView(rcvItem);
    }

    private List<ItemObject> getListItems() {
        List<ItemObject> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            list.add(new ItemObject("Item " + i));
        }

        return list;
    }
}