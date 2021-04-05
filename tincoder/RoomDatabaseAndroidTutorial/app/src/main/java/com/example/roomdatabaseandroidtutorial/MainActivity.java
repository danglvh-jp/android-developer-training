package com.example.roomdatabaseandroidtutorial;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.roomdatabaseandroidtutorial.database.UserDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int MY_REQUEST_CODE = 10;

    private EditText edtUserName;
    private EditText edtAddress;
    private Button btnAddUser;
    private RecyclerView rcvUser;

    private UserAdapter userAdapter;
    private List<User> mListUser;

    private TextView tvDeleteAll;
    private EditText edtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();

        userAdapter = new UserAdapter(new UserAdapter.IClickItemUser() {
            @Override
            public void updateUser(User user) {
                clickUpdateUser(user);
            }

            @Override
            public void deleteUser(User user) {
                clickDeleteUser(user);
            }
        });
        mListUser = new ArrayList<>();
        userAdapter.setData(mListUser);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcvUser.setLayoutManager(linearLayoutManager);

        rcvUser.setAdapter(userAdapter);

        btnAddUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
            }
        });

        tvDeleteAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickDeleteAllUser();
            }
        });

        edtSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    // Logic search
                    handleSearchUser();
                }
                return false;
            }
        });

        loadData();
    }

    public void initUI() {
        edtUserName = findViewById(R.id.edt_username);
        edtAddress = findViewById(R.id.edt_address);
        btnAddUser = findViewById(R.id.btn_add_user);
        rcvUser = findViewById(R.id.rcv_user);
        tvDeleteAll = findViewById(R.id.tv_delete_all);
        edtSearch = findViewById(R.id.edt_search);
    }

    private void addUser() {
        String strUsername = edtUserName.getText().toString().trim();
        String strAddress = edtAddress.getText().toString().trim();

        if (TextUtils.isEmpty(strUsername) || TextUtils.isEmpty(strAddress)) {
            return;
        } else {
            User user = new User(strUsername, strAddress);

            if (isUserExist(user)) {
                displayToast("User exist");
                return;
            } else {
                UserDatabase.getInstance(this).userDAO().insertUser(user);
                displayToast("Add user successfully");

                edtUserName.setText("");
                edtAddress.setText("");

                hideSoftKeyBoard();

                loadData();
            }
        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void hideSoftKeyBoard() {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        } catch (NullPointerException exception) {
            exception.printStackTrace();
        }
    }

    private void loadData() {
        mListUser = UserDatabase.getInstance(this).userDAO().getListUser();
        userAdapter.setData(mListUser);
    }

    public boolean isUserExist(User user) {
        List<User> list = UserDatabase.getInstance(this).userDAO().checkUser(user.getUsername());
        return list != null && !list.isEmpty();
    }

    private void clickUpdateUser(User user) {
        Intent intent = new Intent(MainActivity.this, UpdateActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_user", user);
        intent.putExtras(bundle);
        startActivityForResult(intent, MY_REQUEST_CODE);
    }

    private void clickDeleteUser(final User user) {
        new AlertDialog.Builder(this)
                .setTitle("Confirm delete user")
                .setMessage("Are you sure?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Delete user
                        UserDatabase.getInstance(MainActivity.this).userDAO().deleteUser(user);
                        displayToast("Delete user successfully");

                        loadData();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                loadData();
            }
        }
    }

    private void clickDeleteAllUser() {
        new AlertDialog.Builder(this)
                .setTitle("Confirm delete all user")
                .setMessage("Are you sure?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Delete user
                        UserDatabase.getInstance(MainActivity.this).userDAO().deleteAllUser();
                        displayToast("Delete all user successfully");

                        loadData();
                    }
                })
                .setNegativeButton("No", null)
                .show();
    }

    private void handleSearchUser() {
        String strKeyWord = edtSearch.getText().toString().trim();
        mListUser = new ArrayList<>();
        mListUser = UserDatabase.getInstance(this).userDAO().searchUser(strKeyWord);
        userAdapter.setData(mListUser);
        hideSoftKeyBoard();
    }
}