package com.lkmy.illegal.car.adapter.pageadapter.base;

import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/**
 * 作者:李凯
 * 创建时间:2015/11/13 01:58
 * 描述:抽象的PagerAdapter实现类,封装了内容为View的公共操作.
 */
public abstract class BaseViewPagerAdapter extends PagerAdapter {

    protected SparseArray<View> mViews;

    public BaseViewPagerAdapter() {

        mViews = new SparseArray<View>();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mViews.get(position);
        if (view == null) {
            view = newView(position);
            mViews.put(position, view);
        }
        ViewParent vp = view.getParent();
        if (vp != null) {
            ViewGroup parent = (ViewGroup) vp;
            parent.removeView(view);
        }
        container.addView(view);
        return view;
    }

    public abstract View newView(int position);

    public void notifyUpdateView(int position) {
        View view = updateView(mViews.get(position), position);
        mViews.put(position, view);
        notifyDataSetChanged();
    }

    public View updateView(View view, int position) {
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViews.get(position));
    }
}