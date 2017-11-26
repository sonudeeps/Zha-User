package com.example.nadus.politician.RecyclerViews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.nadus.politician.Adapters.scheduleAdapter;

import java.util.ArrayList;

/**
 * Created by HP on 11/18/2017.
 */

public class scheduleItemAdapter extends RecyclerView.Adapter<scheduleItemAdapter.ViewHolder>{
    int listItemLayout;
    ArrayList<scheduleAdapter> list;
    public scheduleItemAdapter(int layout,ArrayList<scheduleAdapter> list1){
        listItemLayout=layout;
        list=list1;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
        final ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {

    }

    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public ViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void onClick(View view) {

        }
    }
}
