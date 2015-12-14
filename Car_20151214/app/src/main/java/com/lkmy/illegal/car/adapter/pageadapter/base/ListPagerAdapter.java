package com.lkmy.illegal.car.adapter.pageadapter.base;

import android.view.View;

import java.util.List;

/**
 * 作者:李凯
 * 创建时间:2015/11/27 23:53
 * 描述:抽象的PagerAdapter实现类,封装了内容为View,数据为List类型的适配器实现.
 */
public abstract class ListPagerAdapter<T> extends BaseViewPagerAdapter {

    protected List<T> list;

    public ListPagerAdapter(List<T> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    public abstract View newView(int position);

}
