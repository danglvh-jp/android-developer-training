package com.example.sharedpreferencesandroid;

import android.content.Context;

public class DataLocalManager {

    private static final String PREF_FIRST_INSTALL = "PREF_FIRST_INSTALL";
    private static DataLocalManager instance;
    private MySharedPreferenes mySharedPreferenes;

    public static void init(Context context) {
        instance = new DataLocalManager();
        instance.mySharedPreferenes = new MySharedPreferenes(context);
    }

    public static DataLocalManager getInstance() {
        if (instance == null) {
            instance = new DataLocalManager();
        }
        return instance;
    }

    public static void setFirstInstalled(boolean isFirst) {
        DataLocalManager.getInstance().mySharedPreferenes.putBooleanValue(PREF_FIRST_INSTALL, isFirst);
    }

    public static boolean getFirstInstalled() {
        return DataLocalManager.getInstance().mySharedPreferenes.getBooleanValue(PREF_FIRST_INSTALL);
    }
}
