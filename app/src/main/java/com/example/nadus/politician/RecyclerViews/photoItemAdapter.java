package com.example.nadus.politician.RecyclerViews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.nadus.politician.Adapters.photoAdapter;

import java.util.ArrayList;

/**
 * Created by HP on 11/16/2017.
 */

public class photoItemAdapter  extends RecyclerView.Adapter<photoItemAdapter.ViewHolder>
{
    private int listItemLayout;
    private ArrayList<photoAdapter> list1;
    public photoItemAdapter(int layout,ArrayList<photoAdapter> list)
    {
        this.list1=list;
        this.listItemLayout=layout;
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
