package com.example.presidentlistrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class AddEditOne extends AppCompatActivity {

    private Button btnOk;
    private Button btnCancel;
    private EditText edtPresDate;
    private EditText edtPresName;
    private EditText edtPresImageURL;
    private TextView tvPresId;

    private List<President> presidentList;
    MyApplication myApplication = (MyApplication) this.getApplication();

    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_one);

        presidentList = myApplication.getPresidentList();

        btnOk = findViewById(R.id.btn_ok);
        btnCancel = findViewById(R.id.btn_cancel);
        edtPresDate = findViewById(R.id.et_dateElection);
        edtPresName = findViewById(R.id.et_presidentName);
        edtPresImageURL = findViewById(R.id.et_pictureURL);
        tvPresId = findViewById(R.id.tv_presidentIdNumber);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);
        President president = null;
        if (id >= 0) {
            // edit the president
            for (President p : presidentList) {
                if (p.getId() == id) {
                    president = p;
                }
            }

            edtPresName.setText(president.getName());
            edtPresDate.setText(String.valueOf(president.getDateOfElection()));
            edtPresImageURL.setText(president.getImageURL());
            tvPresId.setText(String.valueOf(id));
        } else {
            // create new president
        }

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String presName = edtPresName.getText().toString().trim();
                int presDate = Integer.parseInt(edtPresDate.getText().toString().trim());
                String presImageURL = edtPresImageURL.getText().toString().trim();

                if (id >= 0) {
                    // update
                    President updatePresident = new President(id, presName, presDate, presImageURL);
                    presidentList.set(id, updatePresident);
                } else {
                    // add new president
                    // create President object
                    int nextId = myApplication.getNextId();
                    President president = new President(nextId, presName, presDate, presImageURL);

                    // add the object to the global list of presidents
                    presidentList.add(president);
                    myApplication.setNextId(nextId++);
                }

                // go back to main activity
                Intent intent = new Intent(AddEditOne.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddEditOne.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}