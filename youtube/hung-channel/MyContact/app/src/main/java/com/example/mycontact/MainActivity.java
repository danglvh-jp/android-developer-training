package com.example.mycontact;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Contact> mListContact;
    private ListView mLvContact;
    private ContactAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        initView();
    }

    private void initView(){
        mListContact = new ArrayList<>();

        mLvContact = findViewById(R.id.lv_contact);
        mAdapter = new ContactAdapter(this, mListContact);
        mLvContact.setAdapter(mAdapter);
    }
}