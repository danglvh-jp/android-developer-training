package com.example.expandablelistviewtutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private List<GroupObject> mListGroup;
    private Map<GroupObject, List<ItemObject>> mListItems;
    private ExpandableListViewAdapter expandableListViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = findViewById(R.id.expandableListView);

        mListItems = getListItems();
        mListGroup = new ArrayList<>(mListItems.keySet());

        expandableListViewAdapter = new ExpandableListViewAdapter(mListGroup, mListItems);
        expandableListView.setAdapter(expandableListViewAdapter);

        // Set listener
        expandableListView.setOnGroupClickListener((parent, v, groupPosition, id) -> {
            displayToast(mListGroup.get(groupPosition).getName());
            return false;
        });

        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            displayToast(mListItems.get(mListGroup.get(groupPosition)).get(childPosition).getName());
            return false;
        });

        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                displayToast(mListGroup.get(groupPosition).getName() + " Expand");
            }
        });

        expandableListView.setOnGroupCollapseListener((groupPosition) -> {
            displayToast(mListGroup.get(groupPosition).getName() + " Collapse");
        });
    }

    private Map<GroupObject, List<ItemObject>> getListItems() {
        Map<GroupObject, List<ItemObject>> listMap = new HashMap<>();

        GroupObject groupObject1 = new GroupObject(1, "Group 1");
        GroupObject groupObject2 = new GroupObject(2, "Group 2");
        GroupObject groupObject3 = new GroupObject(3, "Group 3");

        List<ItemObject> objectList1 = new ArrayList<>();
        objectList1.add(new ItemObject(1, "Item 1"));
        objectList1.add(new ItemObject(2, "Item 2"));
        objectList1.add(new ItemObject(3, "Item 3"));

        List<ItemObject> objectList2 = new ArrayList<>();
        objectList2.add(new ItemObject(4, "Item 4"));
        objectList2.add(new ItemObject(5, "Item 5"));
        objectList2.add(new ItemObject(6, "Item 6"));

        List<ItemObject> objectList3 = new ArrayList<>();
        objectList3.add(new ItemObject(7, "Item 7"));
        objectList3.add(new ItemObject(8, "Item 8"));
        objectList3.add(new ItemObject(9, "Item 9"));

        listMap.put(groupObject1, objectList1);
        listMap.put(groupObject2, objectList2);
        listMap.put(groupObject3, objectList3);

        return listMap;
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}