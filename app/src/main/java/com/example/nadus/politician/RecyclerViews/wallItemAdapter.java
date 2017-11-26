package com.example.nadus.politician.RecyclerViews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.nadus.politician.Adapters.wallAdapter;

import java.util.ArrayList;

/**
 * Created by HP on 11/15/2017.
 */

public class wallItemAdapter  extends RecyclerView.Adapter<wallItemAdapter.ViewHolder>{
    private int listItemLayout;
    private ArrayList<wallAdapter> itemList;
    public wallItemAdapter(int layout,ArrayList<wallAdapter> list){
        this.listItemLayout=layout;
        this.itemList=list;
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
    public int getItemCount()
    {
        return itemList==null?0:itemList.size();
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
