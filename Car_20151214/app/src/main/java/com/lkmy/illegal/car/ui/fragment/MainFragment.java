package com.lkmy.illegal.car.ui.fragment;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.lkmy.illegal.car.R;
import com.lkmy.illegal.car.adapter.pageadapter.AutoViewPagerAdapter;
import com.lkmy.illegal.car.model.Carousel;
import com.lkmy.illegal.car.widget.viewpager.AutoScrollViewPager;
import com.lkmy.library.indicator.CirclePageIndicator;
import com.lkmy.library.loadingview.MultiStateView;
import com.lkmy.module.lib.av.LibLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者:李凯
 * 创建时间:2015/11/28 0:17
 * 描述:
 */
public class MainFragment extends BaseFragment {


    private AutoScrollViewPager viewPager;
    private CirclePageIndicator indicator;
    private AutoViewPagerAdapter autoViewPagerAdapter;
    private LibLayout libLayout;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.fragment_main);
        multiStateViewManager.setState(MultiStateView.VIEW_STATE_CONTENT);
        viewPager = getViewById(R.id.fragment_main_viewpager);
        indicator = getViewById(R.id.fragment_main_viewpager_indicator);
        RelativeLayout layout = getViewById(R.id.fragment_main_layout);

        libLayout = new LibLayout(getActivity(), "3685b5d22e2f43649a4f61afde5c9ee4");
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.BELOW, R.id.fragment_main_viewpager);
        layout.addView(libLayout, params);


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (libLayout != null) {
            LibLayout.clear();
            libLayout.clearThread();
        }
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        List<Carousel> list2 = new ArrayList<>();
        list2.add(new Carousel("111", "http://www.baidu.com", "http://img2.3lian.com/img2007/19/33/005.jpg"));
        list2.add(new Carousel("111", "http://www.163.com", "http://pic2.ooopic.com/01/03/51/25b1OOOPIC19.jpg"));
        list2.add(new Carousel("111", "http://10.0.2.3/", "http://pic28.nipic.com/20130402/9252150_190139450381_2.jpg"));
        autoViewPagerAdapter = new AutoViewPagerAdapter(getActivity(), list2);
        viewPager.setAdapter(autoViewPagerAdapter);
        indicator.setViewPager(viewPager);

    }

    @Override
    protected void load() {

    }

}
