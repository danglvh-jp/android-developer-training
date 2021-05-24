package com.example.presidentlistrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PresidentAdapter extends RecyclerView.Adapter<PresidentAdapter.PresidentViewHolder> {

    List<President> presidentList;
    Context context;

    public PresidentAdapter(List<President> presidentList, Context context) {
        this.presidentList = presidentList;
        this.context = context;
    }

    @NonNull
    @NotNull
    @Override
    public PresidentViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_line_president, parent, false);
        return new PresidentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PresidentAdapter.PresidentViewHolder holder, int position) {
        President president = presidentList.get(position);

        if (president == null) {
            return;
        }

        holder.tvPresName.setText(president.getName());
        holder.tvPresElectionDate.setText(String.valueOf(president.getDateOfElection()));
        Glide.with(this.context).load(president.getImageURL()).into(holder.ivPresPic);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // send the control to the EditOneItem Activity
                Intent intent = new Intent(context, AddEditOne.class);
                intent.putExtra("id", presidentList.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (presidentList != null) {
            return presidentList.size();
        }
        return 0;
    }


    public class PresidentViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivPresPic;
        private TextView tvPresName;
        private TextView tvPresElectionDate;
        private ConstraintLayout parentLayout;

        public PresidentViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);

            ivPresPic = itemView.findViewById(R.id.iv_presidentPicture);
            tvPresName = itemView.findViewById(R.id.tv_presName);
            tvPresElectionDate = itemView.findViewById(R.id.tv_dateElection);
            parentLayout = itemView.findViewById(R.id.oneLinePresidentLayout);
        }
    }
}
