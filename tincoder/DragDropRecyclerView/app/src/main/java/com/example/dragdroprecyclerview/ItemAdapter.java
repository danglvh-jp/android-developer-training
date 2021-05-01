package com.example.dragdroprecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<String> mListItem;

    public void setData(List<String> list) {
        this.mListItem = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        String stringItem = mListItem.get(position);
        holder.tvItem.setText(stringItem);
    }

    @Override
    public int getItemCount() {
        if (mListItem != null) {
            return mListItem.size();
        }
        return 0;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView tvItem;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            tvItem = itemView.findViewById(R.id.tv_item);
        }
    }
}
