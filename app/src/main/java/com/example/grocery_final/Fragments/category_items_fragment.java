package com.example.grocery_final.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.example.grocery_final.Adapters.Cat_Items_Adapter;
import com.example.grocery_final.Adapters.Category_RecyclerViewAdapter;
import com.example.grocery_final.Adapters.Slider_Pager_Adapter;
import com.example.grocery_final.R;

import java.util.ArrayList;

public class category_items_fragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_category_items_fragment, container, false);


        return rootview;


    }

}


