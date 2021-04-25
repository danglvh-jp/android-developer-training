package com.example.listtaskcompletedtutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvTask;
    private RecyclerView rcvTaskCompleted;
    private LinearLayout layoutTaskCompleted;
    private TextView tvCountTaskCompleted;
    private ImageView img1;

    private TaskAdapter taskAdapter;
    private TaskAdapter taskAdapterCompleted;

    private List<Task> mListTask;
    private List<Task> mListTaskCompleted = new ArrayList<>();

    private boolean isExpand = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUI();
        setDataListTask();
        setDataListTaskCompleted();
    }

    private void initUI() {
        rcvTask = findViewById(R.id.rcv_task);
        rcvTaskCompleted = findViewById(R.id.rcv_task_completed);
        layoutTaskCompleted = findViewById(R.id.layout_task_completed);
        tvCountTaskCompleted = findViewById(R.id.tv_count_task_completed);
        img1 = findViewById(R.id.img_1);
    }

    private void setDataListTask() {
        // List task
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        rcvTask.setLayoutManager(linearLayoutManager1);
        rcvTask.setNestedScrollingEnabled(false);
        rcvTask.setFocusable(false);

        taskAdapter = new TaskAdapter();
        mListTask = getListTask();
        taskAdapter.setData(mListTask, new TaskAdapter.IListenerClickCheckBox() {
            @Override
            public void onClickCheckBox(Task task, int position) {
                mListTask.remove(task);
                taskAdapter.notifyItemRemoved(position);
                taskAdapter.notifyItemRangeRemoved(position, mListTask.size());

                task.setCompleted(true);
                mListTaskCompleted.add(task);
                taskAdapterCompleted.notifyDataSetChanged();

                showOrHiddenLayoutCompleted();
            }
        });
        rcvTask.setAdapter(taskAdapter);
    }

    private void setDataListTaskCompleted() {
        // List task completed
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        rcvTaskCompleted.setLayoutManager(linearLayoutManager1);
        rcvTaskCompleted.setNestedScrollingEnabled(false);
        rcvTaskCompleted.setFocusable(false);

        taskAdapterCompleted = new TaskAdapter();
        taskAdapterCompleted.setData(mListTaskCompleted, new TaskAdapter.IListenerClickCheckBox() {
            @Override
            public void onClickCheckBox(Task task, int position) {
                mListTaskCompleted.remove(task);
                taskAdapterCompleted.notifyItemRemoved(position);
                taskAdapterCompleted.notifyItemRangeRemoved(position, mListTaskCompleted.size());

                task.setCompleted(false);
                mListTask.add(task);
                taskAdapter.notifyDataSetChanged();

                showOrHiddenLayoutCompleted();
            }
        });
        rcvTaskCompleted.setAdapter(taskAdapterCompleted);
    }

    private List<Task> getListTask() {
        List<Task> list = new ArrayList<>();
        list.add(new Task("Task 1", false));
        list.add(new Task("Task 2", false));
        list.add(new Task("Task 3", false));
        list.add(new Task("Task 4", false));
        list.add(new Task("Task 5", false));

        return list;
    }

    private void showOrHiddenLayoutCompleted() {
        if ((mListTaskCompleted != null) && (mListTaskCompleted.size() > 0)) {
            layoutTaskCompleted.setVisibility(View.VISIBLE);
            tvCountTaskCompleted.setText(String.valueOf(mListTaskCompleted.size()));
        } else {
            layoutTaskCompleted.setVisibility(View.GONE);
        }

        layoutTaskCompleted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isExpand) {
                    isExpand = false;
                    rcvTaskCompleted.setVisibility(View.GONE);
                    img1.setImageResource(R.drawable.ic_right);
                } else {
                    isExpand = true;
                    rcvTaskCompleted.setVisibility(View.VISIBLE);
                    img1.setImageResource(R.drawable.ic_drop_down);
                }
            }
        });
    }
}