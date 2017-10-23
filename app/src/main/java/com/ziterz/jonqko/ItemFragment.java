package com.ziterz.jonqko;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ItemFragment extends Fragment {

    GridView gridView;
    ArrayList<Item> imgArrayList;

    public ItemFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item, container, false);

        gridView = (GridView) view.findViewById(R.id.grid_view);

        imgArrayList = new ArrayList<>();
        imgArrayList.add(new Item(R.drawable.img1));
        imgArrayList.add(new Item(R.drawable.img1));
        imgArrayList.add(new Item(R.drawable.img1));
        imgArrayList.add(new Item(R.drawable.img1));
        imgArrayList.add(new Item(R.drawable.img1));
        imgArrayList.add(new Item(R.drawable.img1));
        imgArrayList.add(new Item(R.drawable.img1));
        imgArrayList.add(new Item(R.drawable.img1));
        imgArrayList.add(new Item(R.drawable.img1));

        final ItemAdapter adapter = new ItemAdapter(getContext(), imgArrayList);
        gridView.setAdapter(adapter);
        gridView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

        return view;
    }

}
