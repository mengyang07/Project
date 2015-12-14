package com.lkmy.illegal.car.model;


import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;

/**
 * Created by 凯 on 2015/11/3.
 */
public class FragmentModel {

    private Fragment fragment;
    private String titleText;

    private int imageRes;


    public FragmentModel(Fragment fragment, String titleText, @DrawableRes int imageRes) {
        this.fragment = fragment;
        this.titleText = titleText;
        this.imageRes = imageRes;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }


}
