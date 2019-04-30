package com.example.grocery_final.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.grocery_final.R;


public class CategoriesFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_categories, container, false);

        LinearLayout linearLayout = (LinearLayout) rootview.findViewById(R.id.item_container);

        View child = getLayoutInflater().inflate(R.layout.cat_items, null);
        linearLayout.addView(child);
        return rootview;
    }
}