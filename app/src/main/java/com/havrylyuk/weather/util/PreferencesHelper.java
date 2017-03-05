package com.havrylyuk.weather.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.havrylyuk.weather.R;
import com.havrylyuk.weather.WeatherApp;

import org.greenrobot.greendao.annotation.NotNull;

/**
 * Preferences Helper
 * Created by Igor Havrylyuk on 11.02.2017.
 */

public class PreferencesHelper {

    private static PreferencesHelper sInstance = null;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    //singleton
    public static PreferencesHelper getInstance() {
        if(sInstance == null) {
            sInstance = new PreferencesHelper();
        }
        return sInstance;
    }

    public PreferencesHelper() {
        this.sharedPreferences = WeatherApp.getSharedPreferences();
        this.editor = this.sharedPreferences.edit();
    }

    //for save data in SharedPreferences
    public void setUnits(Context context, @NotNull String units){
        editor.putString(context.getString(R.string.pref_unit_key), units);
        editor.apply();
    }

    //for the loading of data from SharedPreferences
    public String getUnits(String key){
        return sharedPreferences.getString(key, Utility.getDefaultUnit());
    }


    public void setForecastDays(String name, int days){
        editor.putInt(name, days);
        editor.apply();
    }


    public int getForecastDays(String prefName){
        return sharedPreferences.getInt(prefName, 7);
    }

    public void setUseLocation(Context context, boolean useLocation){
        editor.putBoolean(context.getString(R.string.pref_enable_location_key), useLocation);
        editor.apply();
    }

    public boolean getUseLocation(Context context){
        return sharedPreferences.getBoolean(context.getString(R.string.pref_enable_location_key), true);
    }


}
