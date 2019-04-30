package com.example.grocery_final.Fragments;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.grocery_final.Adapters.Slider_Pager_Adapter;
import com.example.grocery_final.Connection.ConnectionServer;
import com.example.grocery_final.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.grocery_final.helper.Constants.Check;
import static com.example.grocery_final.helper.Constants.Getslides;

public class HomeFragment extends Fragment {
//mywork start
CardView hot_deal;
    //mywork end


    Slider_Pager_Adapter sliderPagerAdapter;
    ArrayList<Integer> slider_image_list = new ArrayList<>();
    int page_position = 0;
    Timer timer;
    private ViewPager images_slider;
    private LinearLayout pages_dots;
    private TextView[] dots;
    private Button category_btn, search_btn;
    FragmentManager fragmentManager = getFragmentManager();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_home, container, false);

        //mywork start here
        search_btn = (Button) rootview.findViewById(R.id.search_button);



        hot_deal = (CardView) rootview.findViewById(R.id.hot_dealing);
        hot_deal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Connection Server Start Here
                //Log.e("test URl",LOGINCHECK);
                ConnectionServer connectionServer = new ConnectionServer();
                connectionServer.set_url(Check);
                connectionServer.requestedMethod("POST");
                //connectionServer.buildParameter("username",username);
                //connectionServer.buildPiarameter("password",password);
                connectionServer.execute(new ConnectionServer.AsyncResponse() {
                    @Override
                    public void processFinish(String output) {
                        Log.e("Server Response",output);
                        JSONObject data= null;

                    }
                });
                /////dfsdf
                Toast.makeText(getActivity(), "HelloMyFriend", Toast.LENGTH_SHORT).show();
            }
        });
        ///mywork end here


        images_slider = rootview.findViewById(R.id.image_page_slider);
        pages_dots = rootview.findViewById(R.id.image_page_dots);

        timer = new Timer();
        initSlider();
        scheduleSlider();


        return rootview;
    }

    public void initSlider() {
        addBottomDots(0);

        slider_image_list = new ArrayList<>();

        //Add few items to slider_image_list ,this should contain url of images which should be displayed in slider
        // here i am adding few sample image links from drawable, we will replace it later

        //Initiating Images from Server Starz
        slider_image_list.add(R.drawable.slider1);
        slider_image_list.add(R.drawable.slider2);

        //Initiating Images from Server End

        sliderPagerAdapter = new Slider_Pager_Adapter(getActivity(), slider_image_list);
        images_slider.setAdapter(sliderPagerAdapter);
        images_slider.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                addBottomDots(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    public void scheduleSlider() {

        final Handler handler = new Handler();

        final Runnable update = new Runnable() {
            public void run() {
                if (page_position == slider_image_list.size()) {
                    page_position = 0;
                } else {
                    page_position = page_position + 1;
                }
                images_slider.setCurrentItem(page_position, true);
            }
        };

        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                handler.post(update);
            }
        }, 500, 4000);
    }

    public void addBottomDots(int currentPage) {
        dots = new TextView[slider_image_list.size()];

        pages_dots.removeAllViews();
        pages_dots.setPadding(0, 0, 0, 20);
        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(getContext());
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(Color.parseColor("#9f9f9f")); // un selected
            pages_dots.addView(dots[i]);
        }

        if (dots.length > 0)
            dots[currentPage].setTextColor(Color.parseColor("#2f383a")); // selected
    }

    @Override
    public void onPause() {
        timer.cancel();
        super.onPause();
    }


}
