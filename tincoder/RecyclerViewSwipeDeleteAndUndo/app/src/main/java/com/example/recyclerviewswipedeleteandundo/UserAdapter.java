package com.example.recyclerviewswipedeleteandundo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> mListUser;

    public UserAdapter(List<User> mListUser) {
        this.mListUser = mListUser;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mListUser.get(position);
        if (user == null) {
            return;
        }

        holder.tvName.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        if (mListUser != null) {
            return mListUser.size();
        } else {
            return 0;
        }
    }

    class UserViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        LinearLayout layoutForeGround;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tv_name);
            layoutForeGround = itemView.findViewById(R.id.layout_foreground);
        }
    }

    public void removeItem(int index) {
        mListUser.remove(index);
        notifyItemRemoved(index);
    }

    public void undoItem(User user, int index) {
        mListUser.add(index, user);
        notifyItemInserted(index);
    }
}
