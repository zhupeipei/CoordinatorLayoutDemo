package com.example.myapplication.mainactivity;

import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.RvHolder> {

    @NonNull
    @Override
    public RvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView tv = new TextView(parent.getContext());
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(20);
        return new RvHolder(tv);
    }

    @Override
    public void onBindViewHolder(@NonNull RvHolder holder, int position) {
        TextView tv = (TextView) holder.itemView;
        tv.setText("item" + position);
        tv.setLayoutParams(new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200 * 3));
    }

    @Override
    public int getItemCount() {
        return 10;
    }

    static class RvHolder extends RecyclerView.ViewHolder {
        public RvHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
