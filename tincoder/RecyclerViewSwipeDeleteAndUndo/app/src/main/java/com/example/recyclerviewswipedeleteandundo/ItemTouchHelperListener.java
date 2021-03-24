package com.example.recyclerviewswipedeleteandundo;

import androidx.recyclerview.widget.RecyclerView;

public interface ItemTouchHelperListener {

    void onSwipe(RecyclerView.ViewHolder viewHolder);
}
