package com.example.recyclerviewproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    private ArrayList<ExampleItem> mExampleItemList;

    public ExampleAdapter(ArrayList<ExampleItem> mExampleItemList) {
        this.mExampleItemList = mExampleItemList;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull ExampleAdapter.ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleItemList.get(position);

        if (currentItem == null) {
            return;
        }

        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
    }

    @Override
    public int getItemCount() {
        if (mExampleItemList != null) {
            return mExampleItemList.size();
        }
        return 0;
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageView;
        private TextView mTextView1;
        private TextView mTextView2;

        public ExampleViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.imageView);
            mTextView1 = itemView.findViewById(R.id.textView);
            mTextView2 = itemView.findViewById(R.id.textView2);
        }
    }
}
