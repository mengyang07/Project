package com.lkmy.illegal.car.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.lkmy.illegal.car.R;
import com.lkmy.illegal.car.adapter.pageadapter.LoginVpAdapter;
import com.lkmy.library.indicator.CirclePageIndicator;

/**
 * 作者:李凯
 * 创建时间:2015/11/13 00:24
 * 描述:
 */
public class LoginActivity extends BaseActivity {

    private ViewPager viewPager;
    private CirclePageIndicator circlePageIndicator;
    private LoginVpAdapter loginVpAdapter;
    private static final int[] pics = {R.drawable.ee, R.drawable.dd, R.drawable.ee, R.drawable.dd};


    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
        viewPager = getViewById(R.id.activity_login_viewpager);
        circlePageIndicator = getViewById(R.id.activity_login_viewpager_indicator);

    }

    @Override
    protected void setListener() {
    }

    @Override
    protected void processLogic(Bundle savedInstanceState) {
        loginVpAdapter = new LoginVpAdapter(pics, this);
        viewPager.setAdapter(loginVpAdapter);
        circlePageIndicator.setViewPager(viewPager);
    }
}
