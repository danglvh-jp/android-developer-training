package com.example.sqldemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button btnAdd;
    private Button btnViewAll;
    private EditText edtName;
    private EditText edtAge;
    private Switch swActiveCustomer;
    ListView lvCustomerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btn_add);
        btnViewAll = findViewById(R.id.btn_viewAll);
        edtAge = findViewById(R.id.et_age);
        edtName = findViewById(R.id.et_name);
        swActiveCustomer = findViewById(R.id.sw_active);
        lvCustomerList = findViewById(R.id.lv_customerList);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                CustomerModel customerModel;

                try {
                    customerModel = new CustomerModel(-1, edtName.getText().toString(), Integer.parseInt(edtAge.getText().toString()), swActiveCustomer.isChecked());
                    displayToast(customerModel.toString());
                } catch (Exception e) {
                    displayToast("Error creating customer");
                    customerModel = new CustomerModel(-1, "error", 0, false);
                }

                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);

                boolean success = dataBaseHelper.addOne(customerModel);

                displayToast("Success");
            }
        });

        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
                List<CustomerModel> everyone = dataBaseHelper.getEveryone();

                displayToast(everyone.toString());
            }
        });
    }

    private void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}