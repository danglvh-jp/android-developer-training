package com.example.sortingexample;

public class ExampleItem {

    private int mImageResource;
    private String mText1;
    private String mText2;

    public ExampleItem(int mImageResource, String mText1, String mText2) {
        this.mImageResource = mImageResource;
        this.mText1 = mText1;
        this.mText2 = mText2;
    }

    public int getImageResource() {
        return mImageResource;
    }

    public void setImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }

    public String getText1() {
        return mText1;
    }

    public void setText1(String mText1) {
        this.mText1 = mText1;
    }

    public String getText2() {
        return mText2;
    }

    public void setText2(String mText2) {
        this.mText2 = mText2;
    }
}
