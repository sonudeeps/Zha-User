package com.example.nadus.politician.New_Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.nadus.politician.Adapters.wallAdapter;
import com.example.nadus.politician.R;
import com.example.nadus.politician.RecyclerViews.wallItemAdapter;

import java.util.ArrayList;

/**
 * Created by admin on 18-11-2017.
 */

public class Wall extends Fragment
{
    RecyclerView recyclerView;
    ArrayList<wallAdapter> wa=new ArrayList<>();
    wallItemAdapter wtd;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.wall_recycler,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recycler_wall);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        wa.add(new wallAdapter());
        wa.add(new wallAdapter());
        wa.add(new wallAdapter());

        wtd=new wallItemAdapter(R.layout.wall_card,wa);
        recyclerView.setAdapter(wtd);
        return view;
    }
}
