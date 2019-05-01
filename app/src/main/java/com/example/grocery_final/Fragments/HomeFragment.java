package com.example.grocery_final.Fragments;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.grocery_final.Adapters.Category_RecyclerViewAdapter;
import com.example.grocery_final.Adapters.Slider_Adapter;
import com.example.grocery_final.Connection.ConnectionServer;
import com.example.grocery_final.MainActivity;
import com.example.grocery_final.R;

import org.json.JSONObject;

import java.util.ArrayList;

import static com.example.grocery_final.helper.Constants.Check;
import static com.example.grocery_final.helper.Constants.Getslides;

public class HomeFragment extends Fragment {
//mywork start
CardView hot_deal;

    RecyclerView recyclerView;
    ArrayList<String> Number;
    RecyclerView.LayoutManager RecyclerViewLayoutManager;
    Category_RecyclerViewAdapter category_recyclerViewAdapter;
    LinearLayoutManager HorizontalLayout ;
    View ChildView ;
    int RecyclerViewItemPosition ;

    //slider work
    ViewPager viewPager;
    int images[] = {R.drawable.slider1, R.drawable.slider2, R.drawable.slider3, R.drawable.slider4};

    Slider_Adapter slider_adapter;
    //slider end
    //mywork end


    private Button category_btn, search_btn;
    FragmentManager fragmentManager = getFragmentManager();
    private ImageView imageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_home, container, false);
        //mywork start here

        viewPager = (ViewPager)rootview.findViewById(R.id.viewPager);
        slider_adapter = new Slider_Adapter(getActivity(), images, images);

        viewPager.setAdapter(slider_adapter);

        recyclerView = (RecyclerView)rootview.findViewById(R.id.recyclerview1);

        RecyclerViewLayoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(RecyclerViewLayoutManager);

        // Adding items to RecyclerView.
        AddItemsToRecyclerViewArrayList();

        category_recyclerViewAdapter = new Category_RecyclerViewAdapter(Number);

        HorizontalLayout = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(HorizontalLayout);

        recyclerView.setAdapter(category_recyclerViewAdapter);
        recyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {

            GestureDetector gestureDetector = new GestureDetector(getActivity(), new GestureDetector.SimpleOnGestureListener() {

                @Override public boolean onSingleTapUp(MotionEvent motionEvent) {

                    return true;
                }

            });
            @Override
            public boolean onInterceptTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {

                ChildView = Recyclerview.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

                if(ChildView != null && gestureDetector.onTouchEvent(motionEvent)) {

                    //Getting clicked value.
                    RecyclerViewItemPosition = Recyclerview.getChildAdapterPosition(ChildView);

                    // Showing clicked item value on screen using toast message.
                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

                    fragmentManager.beginTransaction().replace(R.id.main_fragment_container, new CategoriesFragment(), "CategoriesFragment")
                            .commit();



                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView Recyclerview, MotionEvent motionEvent) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });


        //dynamic image start
        imageView = (ImageView) rootview.findViewById(R.id.imageview);
        Glide.with(this).load("http://i.imgur.com/DvpvklR.png").into(imageView);
        //dynamic image end
        search_btn = (Button) rootview.findViewById(R.id.search_button);


        ///mywork end here


        return rootview;
    }



    public void AddItemsToRecyclerViewArrayList(){

        Number = new ArrayList<>();
        Number.add("Categories");
        Number.add("TWO");
        Number.add("THREE");
        Number.add("FOUR");
        Number.add("FIVE");
        Number.add("SIX");
        Number.add("SEVEN");
        Number.add("EIGHT");
        Number.add("NINE");
        Number.add("TEN");

    }


}
