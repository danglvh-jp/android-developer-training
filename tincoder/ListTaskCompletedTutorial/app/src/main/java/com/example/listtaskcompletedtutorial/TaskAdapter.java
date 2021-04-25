package com.example.listtaskcompletedtutorial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private List<Task> mListTask;
    private IListenerClickCheckBox iListenerClickCheckBox;

    public interface IListenerClickCheckBox {
        void onClickCheckBox(Task task, int position);
    }

    public void setData(List<Task> list, IListenerClickCheckBox iListenerClickCheckBox) {
        this.mListTask = list;
        this.iListenerClickCheckBox = iListenerClickCheckBox;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, final int position) {
        final Task task = mListTask.get(position);
        if (task == null) {
            return;
        }
        holder.chbComplete.setChecked(task.isCompleted());
        holder.tvTask.setText(task.getName());

        holder.chbComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iListenerClickCheckBox.onClickCheckBox(task, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mListTask != null) {
            return mListTask.size();
        }
        return 0;
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {

        private CheckBox chbComplete;
        private TextView tvTask;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);

            chbComplete = itemView.findViewById(R.id.chb_complete);
            tvTask = itemView.findViewById(R.id.tv_task);
        }
    }
}
