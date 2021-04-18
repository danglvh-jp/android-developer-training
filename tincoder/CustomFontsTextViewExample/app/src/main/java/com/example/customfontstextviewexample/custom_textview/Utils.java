package com.example.customfontstextviewexample.custom_textview;

import android.content.Context;
import android.graphics.Typeface;

public class Utils {

    private static Typeface GreatVibesTypeface;
    private static Typeface OpenSansTypeface;
    private static Typeface SourceSansProTypeface;
    private static Typeface RalewayTypeface;
    private static Typeface RobotoTypeface;

    public static Typeface getGreatVibesTypeface(Context context) {
        if (GreatVibesTypeface == null) {
            GreatVibesTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/GreatVibes-Regular.otf");
        }
        return GreatVibesTypeface;
    }

    public static Typeface getOpenSansTypeface(Context context) {
        if (OpenSansTypeface == null) {
            OpenSansTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/OpenSans-Bold.ttf");
        }
        return OpenSansTypeface;
    }

    public static Typeface getSourceSansProTypeface(Context context) {
        if (SourceSansProTypeface == null) {
            SourceSansProTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/SourceSansPro-Light.otf");
        }
        return SourceSansProTypeface;
    }

    public static Typeface getRalewayTypeface(Context context) {
        if (RalewayTypeface == null) {
            RalewayTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/Raleway-Black.ttf");
        }
        return RalewayTypeface;
    }

    public static Typeface getRobotoTypeface(Context context) {
        if (RobotoTypeface == null) {
            RobotoTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Black.ttf");
        }
        return RobotoTypeface;
    }
}
