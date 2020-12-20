package com.note11.client_119.util;


import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;

public class GpsCache {

    public static SharedPreferences getShared(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setGps(Context context, GpsModel model){
        Gson gson = new Gson();
        String json = gson.toJson(model);
        SharedPreferences.Editor editor = getShared(context).edit();
        editor.putString("Gps",json).apply();
    }

    public static GpsModel getGps(Context context){
        Gson gson = new Gson();
        return gson.fromJson(getShared(context).getString("Gps",""), GpsModel.class);
    }

    public static void clear(Context context){
        SharedPreferences.Editor editor = getShared(context).edit();
        editor.putString("Gps", null).apply();
    }

}
