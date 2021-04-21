package com.example.filterlistwithsearchview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvUsers;
    private UserAdapter userAdapter;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcvUsers = findViewById(R.id.rcv_users);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvUsers.setLayoutManager(linearLayoutManager);

        userAdapter = new UserAdapter(getListUsers());
        rcvUsers.setAdapter(userAdapter);

        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rcvUsers.addItemDecoration(itemDecoration);
    }

    private List<User> getListUsers() {
        List<User> list = new ArrayList<>();
        list.add(new User(R.drawable.pink_elephant, "TinCoder", "Ha Noi"));
        list.add(new User(R.drawable.gray_elephant, "Nguyen Van Ha", "Thai Nguyen"));
        list.add(new User(R.drawable.brown_bear, "Nguyen Van Anh", "Thai Binh"));
        list.add(new User(R.drawable.yellow_bear, "Nguyen Thi Van", "Da Nang"));
        list.add(new User(R.drawable.yellow_dog, "Tran Manh Cuong", "Hai Phong"));
        list.add(new User(R.drawable.pink_elephant, "Pham Dinh Hung", "Ha Nam"));
        list.add(new User(R.drawable.gray_elephant, "Dang Thu Thuy", "Sai Gon"));
        list.add(new User(R.drawable.brown_bear, "Ta Quang Minh", "Bac Ninh"));
        list.add(new User(R.drawable.yellow_bear, "Dang Dinh Hung", "Bac Giang"));
        list.add(new User(R.drawable.yellow_dog, "Nguyen Dang Tu", "Ha Giang"));

        return list;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);

        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) menu.findItem(R.id.action_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                userAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                userAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }

    @Override
    public void onBackPressed() {
        if (!searchView.isIconified()) {
            searchView.setIconified(true);
            return;
        }
        super.onBackPressed();
    }
}