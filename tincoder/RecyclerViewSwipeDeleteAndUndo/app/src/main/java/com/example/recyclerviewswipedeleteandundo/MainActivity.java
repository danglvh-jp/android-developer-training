package com.example.recyclerviewswipedeleteandundo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemTouchHelperListener {

    private RecyclerView rcvUser;
    private UserAdapter adapter;
    private List<User> mListUsers;

    private RelativeLayout rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rootView = findViewById(R.id.root_view);

        rcvUser = findViewById(R.id.rcv_user);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvUser.setLayoutManager(linearLayoutManager);

        mListUsers = getListUsers();
        adapter = new UserAdapter(mListUsers);
        rcvUser.setAdapter(adapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvUser.addItemDecoration(itemDecoration);

        ItemTouchHelper.SimpleCallback simpleCallback = new RecyclerViewItemTouchHelper(0, ItemTouchHelper.LEFT, this);
        new ItemTouchHelper(simpleCallback).attachToRecyclerView(rcvUser);
    }

    private List<User> getListUsers() {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(new User("User name " + (i + 1)));
        }
        return list;
    }

    @Override
    public void onSwipe(RecyclerView.ViewHolder viewHolder) {
        if (viewHolder instanceof UserAdapter.UserViewHolder) {
            String nameUserDelete = mListUsers.get(viewHolder.getAdapterPosition()).getName();

            final User userDelete = mListUsers.get(viewHolder.getAdapterPosition());
            final int indexDelete = viewHolder.getAdapterPosition();

            //remove item
            adapter.removeItem(indexDelete);

            Snackbar snackbar = Snackbar.make(rootView, nameUserDelete + " remove!", Snackbar.LENGTH_LONG);
            snackbar.setAction("UNDO", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapter.undoItem(userDelete, indexDelete);
                    if (indexDelete == 0 || indexDelete == mListUsers.size() - 1) {
                        rcvUser.scrollToPosition(indexDelete);
                    }
                }
            });
            snackbar.setActionTextColor(Color.YELLOW);
            snackbar.show();
        }
    }
}