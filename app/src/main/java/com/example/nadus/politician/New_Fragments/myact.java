package com.example.nadus.politician.New_Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.example.nadus.politician.Adapters.Adapter;
import com.example.nadus.politician.R;
import com.example.nadus.politician.RecyclerViews.itemAdapter;

import java.util.ArrayList;

/**
 * Created by HP on 7/13/2017.
 */

public class myact extends Fragment
{
    public ArrayList<Adapter> adapters=new ArrayList<Adapter>();
    //public itemAdapter itemArrayAdapter = new itemAdapter(R.layout.row,adapters);
    RecyclerView recyclerView1;
    ImageView ig1,ig2;
    public myact()
    {

    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        View view;
        view=inflater.inflate(R.layout.eventfragment,container,false);
        ig1=(ImageView)view.findViewById(R.id.imageButton);
        ig2=(ImageView)view.findViewById(R.id.imageView2);
        ig1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                getActivity().finish();
            }
        });
        ig2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

            }
        });
       recyclerView1=(RecyclerView)view.findViewById(R.id.recyclerView);
       recyclerView1.setLayoutManager(new LinearLayoutManager(view.getContext()));
//        //recyclerView.addItemDecoration(itemDecoration);
////        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapters.add(new Adapter("BirthDay","Am organizing a party ","2/7/2017","5/7/2017","Puducherry",""+2,""+0));
       adapters.add(new Adapter("Long Drive","Lets Rock","3/7/2017","11/7/2017","Puducherry","",""));
       adapters.add(new Adapter("Trainer Meeting","Regarding training skills","21/7/2017","5/8/2017","Puducherry",""+4,""+2));
       itemAdapter itemArrayAdapter = new itemAdapter(R.layout.row2,adapters);
       recyclerView1.setAdapter(itemArrayAdapter);
        return view ;

    }
}
