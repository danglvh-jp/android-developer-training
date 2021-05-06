package com.example.mycontact;

import android.graphics.Bitmap;

public class Contact {

    private String mName;
    private String mPhoneNumber;
    private Bitmap mAvatar;

    public Contact(String mName, String mPhoneNumber, Bitmap mAvatar) {
        this.mName = mName;
        this.mPhoneNumber = mPhoneNumber;
        this.mAvatar = mAvatar;
    }

    public String getName() {
        return mName;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public Bitmap getAvatar() {
        return mAvatar;
    }
}
