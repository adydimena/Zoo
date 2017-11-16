package com.example.ady.zoo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ady on 11/14/2017.
 */

public class Recycleadapter extends RecyclerView.Adapter<Recycleadapter.ViewHolder> {
    List<String> list = new ArrayList<>();



    public Recycleadapter(List<String> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycleviewlayout,null);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (list.get(position) != null);
        holder.recycleDisplay.setText(list.get(position));


    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView recycleDisplay;
        public ViewHolder(View itemView) {
            super(itemView);
            recycleDisplay = itemView.findViewById(R.id.recycleDisplay);
        }
    }

}
