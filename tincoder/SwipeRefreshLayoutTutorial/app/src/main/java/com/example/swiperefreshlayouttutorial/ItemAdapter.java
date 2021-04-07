package com.example.swiperefreshlayouttutorial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<ItemObject> mListItem;

    public void setData(List<ItemObject> list) {
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
        ItemObject itemObject = mListItem.get(position);
        if (itemObject == null) {
            return;
        } else {
            holder.tvName.setText(itemObject.getName());
        }
    }

    @Override
    public int getItemCount() {
        if (mListItem != null) {
            return mListItem.size();
        } else {
            return 0;
        }
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
        }
    }
}
