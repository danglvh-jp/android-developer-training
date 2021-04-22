package com.example.recyclerviewmvvmlivedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class UserViewModel extends ViewModel {

    private MutableLiveData<List<User>> mListUserLiveData;
    private List<User> mListUser;

    public UserViewModel() {
        mListUserLiveData = new MutableLiveData<>();

        initData();
    }

    private void initData() {
        mListUser = new ArrayList<>();
        mListUser.add(new User(R.drawable.yellow_bear, "Yellow Bear", "Gau bong gau mau vang"));

        mListUserLiveData.setValue(mListUser);
    }

    public MutableLiveData<List<User>> getListUserLiveData() {
        return mListUserLiveData;
    }

    public void addUser(User user) {
        mListUser.add(0, user);
        mListUserLiveData.setValue(mListUser);
    }
}
