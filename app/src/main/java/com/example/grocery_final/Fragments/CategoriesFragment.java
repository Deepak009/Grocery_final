package com.example.grocery_final.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.grocery_final.Adapters.GridProductLayoutAdapter;
import com.example.grocery_final.Adapters.HorizontalProductScrollModel;
import com.example.grocery_final.MainActivity;
import com.example.grocery_final.R;

import java.util.ArrayList;
import java.util.List;


public class CategoriesFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories, container, false);

            // Inflate the layout for this fragment
            List<HorizontalProductScrollModel> horizontalProductScrollModelList = new ArrayList<>();



        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.fb,"Apple iPhone XS","A12 Bionic Chip","Rs.99,900/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.fb,"Apple iPhone XS","A12 Bionic Chip","Rs.99,900/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.fb,"Apple iPhone XS","A12 Bionic Chip","Rs.99,900/-"));
        horizontalProductScrollModelList.add(new HorizontalProductScrollModel(R.drawable.fb,"Apple iPhone XS","A12 Bionic Chip","Rs.99,900/-"));



       /* HorizontalProductScrollAdapter horizontalProductScrollAdapter = new HorizontalProductScrollAdapter(horizontalProductScrollModelList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontalRecyclerView.setLayoutManager(linearLayoutManager);

        horizontalRecyclerView.setAdapter(horizontalProductScrollAdapter);
        horizontalProductScrollAdapter.notifyDataSetChanged();*/


            TextView gridLayoutTitle = view.findViewById(R.id.grid_product_layout_title);
            Button gridLayoutViewAllBtn = view.findViewById(R.id.grid_product_layout_viewall_btn);
            GridView gridView = view.findViewById(R.id.grid_product_layout_gridview);

            gridView.setAdapter(new GridProductLayoutAdapter(horizontalProductScrollModelList));

            return view;
    }
}