package com.example.nadus.politician.RecyclerViews;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.nadus.politician.Adapters.Adapter;
import com.example.nadus.politician.R;

import java.io.File;
import java.util.ArrayList;




/**
 * Created by HP on 6/26/2017.
 */

public class itemAdapter extends  RecyclerView.Adapter<itemAdapter.ViewHolder>
{
    private int listItemLayout;
    private ArrayList<Adapter> itemList;
    public static String str1;
    private static Uri imageUri;
    private static Intent intent;
    private static File output=null;



    //CustomItemClickListener listener;

    // Constructor of the class
    public itemAdapter(int layoutId, ArrayList<Adapter> itemList) {
        listItemLayout = layoutId;
        this.itemList = itemList;
    }


    @Override
    public itemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(listItemLayout, parent, false);
        final ViewHolder myViewHolder = new ViewHolder(view);


        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(itemAdapter.ViewHolder holder, int position)
    {
        TextView item = holder.item;
        TextView item1=holder.item1;
        TextView item2=holder.item2;
        TextView item3=holder.item3;
        TextView item4=holder.item4;
        TextView item5=holder.item5;
        TextView item6=holder.item6;
        //ImageView item1=holder.imageView;
        item.setText(itemList.get(position).getName());
        item1.setText(itemList.get(position).getDesp());
        item2.setText(itemList.get(position).getStart());
        item3.setText(itemList.get(position).getEnd());
        item4.setText(itemList.get(position).getLocation());
        item5.setText(itemList.get(position).getCom());
        item6.setText(itemList.get(position).getNotcom());
        //item1.setImageResource(itemList.get(position).getName());


    }

    @Override
    public int getItemCount()
    {

        return itemList == null ? 0 : itemList.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView item,item1,item2,item3,item4,item5,item6;
        public ImageView imageView,share;
        public ViewHolder(View itemView)
        {
            super(itemView);
            item=(TextView)itemView.findViewById(R.id.eventname);
            item1=(TextView)itemView.findViewById(R.id.textView8);
            item2=(TextView)itemView.findViewById(R.id.startdateC);
            item3=(TextView)itemView.findViewById(R.id.enddateC);
            item4=(TextView)itemView.findViewById(R.id.locationC);
            item5=(TextView)itemView.findViewById(R.id.attendcount);
            item6=(TextView)itemView.findViewById(R.id.notattendcount);

        }
        @Override
        public void onClick(View view) {

            Context context=view.getContext();

            }

        }


    }

