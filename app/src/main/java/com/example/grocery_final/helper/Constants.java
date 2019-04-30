package com.example.grocery_final.helper;

import android.util.Log;

import com.example.grocery_final.Connection.ConnectionServer;

import org.json.JSONObject;

/**
 * Created by iwish on 5/23/2017.
 * http://192.168.1.222/grocery_website/admin/android_process/check_user.php
 */
public class Constants {
    public static String STARTUP_SCREEN_SF = "startup_screen_sf";
    //public static String URL = "http://192.168.1.202/";
    // public static String URL = "http://192.168.219.2/";
    public static String URL = "http://192.168.1.222/";
    public static String SUBFOLDER = "grocery_website/admin/android_process/";


    //File Naming
    public static String Check = URL+SUBFOLDER+"check_user.php";

    public static String Getslides = URL+SUBFOLDER+"getslides.php";


   /* //Connection Server Start Here
    //Log.e("test URl",LOGINCHECK);
    ConnectionServer connectionServer = new ConnectionServer();
                connectionServer.set_url(Check);
                connectionServer.requestedMethod("POST");
    //connectionServer.buildParameter("username",username);
    //connectionServer.buildParameter("password",password);
                connectionServer.execute(new ConnectionServer.AsyncResponse() {
        @Override
        public void processFinish(String output) {
            Log.e("Server Response",output);
            JSONObject data= null;

        }
    });*/

}
