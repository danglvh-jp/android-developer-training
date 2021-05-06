package com.example.customspinner;

public class CountryItem {

    private String mCountryName;
    private int mFlagImage;

    public CountryItem(String mCountryName, int mFlagImage) {
        this.mCountryName = mCountryName;
        this.mFlagImage = mFlagImage;
    }

    public String getCountryName() {
        return mCountryName;
    }

    public int getFlagImage() {
        return mFlagImage;
    }
}
