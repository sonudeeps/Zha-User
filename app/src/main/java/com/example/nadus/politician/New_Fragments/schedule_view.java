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
import android.widget.TextView;


import com.example.nadus.politician.Adapters.dummy;
import com.example.nadus.politician.Adapters.scheduleAdapter;
import com.example.nadus.politician.R;
import com.example.nadus.politician.RecyclerViews.scheduleItemAdapter;

import java.util.ArrayList;

/**
 * Created by HP on 11/18/2017.
 */

public class schedule_view extends Fragment
{
    TextView t1,t2;
    ImageView ig1;
    RecyclerView recyclerView;
    ArrayList<scheduleAdapter> sad=new ArrayList<>();
    scheduleItemAdapter sID;
    public schedule_view() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view1;
        view1 = inflater.inflate(R.layout.schedulerecycler, container, false);
        t1=(TextView)view1.findViewById(R.id.add);
        t2=(TextView)view1.findViewById(R.id.date);
        ig1=(ImageView)view1.findViewById(R.id.imageButton);
        t2.setText(dummy.date_picked);
        recyclerView=(RecyclerView)view1.findViewById(R.id.recycler_schedule);
        recyclerView.setLayoutManager(new LinearLayoutManager(view1.getContext()));
        sad.add(new scheduleAdapter());
        sad.add(new scheduleAdapter());
        sad.add(new scheduleAdapter());
        sad.add(new scheduleAdapter());
        sad.add(new scheduleAdapter());
        ig1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // getFragmentManager().beginTransaction().replace(R.id.frame_container,new schedule()).commit();
            }
        });

        sID=new scheduleItemAdapter(R.layout.schedulecard,sad);
        recyclerView.setAdapter(sID);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
               // getFragmentManager().beginTransaction().replace(R.id.frame_container,new create_schedule()).commit();
            }
        });

        return view1;
    }
}
