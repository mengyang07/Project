package com.lkmy.illegal.car.adapter.pageadapter.base;

import android.view.View;

/**
 * 作者:李凯
 * 创建时间:2015/11/13 02:10
 * 描述:抽象的PagerAdapter实现类,封装了内容为View,数据为int[]类型的适配器实现.
 */
public abstract class DigitGroupPagerAdapter extends BaseViewPagerAdapter {

    protected int[] mData;

    public DigitGroupPagerAdapter(int[] data) {

        this.mData = data;
    }

    @Override
    public int getCount() {

        return mData.length;
    }

    public abstract View newView(int position);


}
