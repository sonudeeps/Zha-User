package com.example.nadus.politician.New_Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.example.nadus.politician.Adapters.photoAdapter;
import com.example.nadus.politician.R;
import com.example.nadus.politician.RecyclerViews.photoItemAdapter;

import java.util.ArrayList;

/**
 * Created by HP on 11/16/2017.
 */

public class photos extends Fragment {
         RecyclerView recyclerView;
         ImageView ig1,ig2;
    private StaggeredGridLayoutManager gaggeredGridLayoutManager;
        ArrayList<photoAdapter> pa=new ArrayList<>();
        photoItemAdapter pTD;
    public photos()
    {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.photos,container,false);
        recyclerView=(RecyclerView)view.findViewById(R.id.recycler_photos);
        gaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, 1);
        recyclerView.setLayoutManager(gaggeredGridLayoutManager);
        ig1=(ImageView)view.findViewById(R.id.imageButton);
        ig2=(ImageView)view.findViewById(R.id.imageView2);
        ig1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });
        ig2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
               // getFragmentManager().beginTransaction().add(R.id.frame_container,new create_photo()).commit();
            }
        });
        int i=10;
        while(i>=0) {
            pa.add(new photoAdapter());
            i--;
        }
        pTD=new photoItemAdapter(R.layout.photos_card,pa);
        recyclerView.setAdapter(pTD);
        return view;
    }
}
