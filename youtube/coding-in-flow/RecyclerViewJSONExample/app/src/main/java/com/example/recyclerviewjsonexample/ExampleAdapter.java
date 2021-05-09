package com.example.recyclerviewjsonexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {

    private Context mContext;
    private ArrayList<ExampleItem> mExampleList;

    public ExampleAdapter(Context mContext, ArrayList<ExampleItem> mExampleList) {
        this.mContext = mContext;
        this.mExampleList = mExampleList;
    }

    @NonNull
    @NotNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.example_item, parent, false);
        return new ExampleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ExampleAdapter.ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);
        if (currentItem == null) {
            return;
        }

        String imageUrl = currentItem.getImageUrl();
        String creatorName = currentItem.getCreator();
        int likeCount = currentItem.getLikes();

        holder.mTextViewCreator.setText(creatorName);
        holder.mTextViewLikes.setText("Likes: " + likeCount);
        if (imageUrl.isEmpty()) {
            holder.mImageView.setImageResource(R.mipmap.ic_launcher);
        } else {
            Picasso.get().load(imageUrl).fit().centerInside().into(holder.mImageView);
        }
    }

    @Override
    public int getItemCount() {
        if (mExampleList != null) {
            return mExampleList.size();
        }
        return 0;
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextViewCreator;
        public TextView mTextViewLikes;

        public ExampleViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.image_view);
            mTextViewCreator = itemView.findViewById(R.id.text_view_creator);
            mTextViewLikes = itemView.findViewById(R.id.text_view_downloads);
        }
    }
}
