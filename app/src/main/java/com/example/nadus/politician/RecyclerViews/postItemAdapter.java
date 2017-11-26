package com.example.nadus.politician.RecyclerViews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.nadus.politician.Adapters.postAdapter;

import java.util.ArrayList;

/**
 * Created by HP on 11/17/2017.
 */

public class postItemAdapter extends RecyclerView.Adapter<postItemAdapter.ViewHolder> {
    private int listItemLayout1;

    private ArrayList<postAdapter> list1;
    public postItemAdapter(int layout,ArrayList<postAdapter> list)
    {
        listItemLayout1=layout;
        list1=list;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout1, parent, false);
        final ViewHolder myViewHolder = new ViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {

    }

    @Override
    public int getItemCount()
    {
        return list1==null?0:list1.size();
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
