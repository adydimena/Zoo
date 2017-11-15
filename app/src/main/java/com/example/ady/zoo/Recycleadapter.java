package com.example.ady.zoo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ady on 11/14/2017.
 */

public class Recycleadapter extends RecyclerView.Adapter<Recycleadapter.View> {
    List<String> list = new ArrayList<>();

    public Recycleadapter(List<String> list) {
        this.list = list;
    }

    @Override
    public Recycleadapter.View onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(Recycleadapter.View holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class View extends RecyclerView.ViewHolder {
        public View(android.view.View itemView) {
            super(itemView);
        }
    }
}
