package com.lkmy.illegal.car.widget;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.lkmy.illegal.car.util.ToastUtil;
import com.lkmy.library.R;
import com.lkmy.library.loadingview.MultiStateView;
import com.lkmy.illegal.car.util.NetworkUtils;


/**
 * 作者:李凯
 * 创建时间:2015/12/7 1:12
 * 描述:
 */
public class MultiStateViewManager {
    private MultiStateView multiStateView;
    private Button button;


    public MultiStateViewManager(Context context) {
        multiStateView = (MultiStateView) LayoutInflater.from(context).inflate(R.layout.multi_layout, null);
        init(context);
    }

    private void init(Context context) {
        if (NetworkUtils.isNetworkConnected(context))
            setState(MultiStateView.VIEW_STATE_LOADING);
        else {
            ToastUtil.show("连接失败,请检查网络连接是否开启。");
            setState(MultiStateView.VIEW_STATE_ERROR);
        }
    }

    public void setMultiStateView(MultiStateView multiStateView) {
        this.multiStateView = multiStateView;
    }

    public void setMultiStateView(@LayoutRes int resLayout, Context context) {
        multiStateView = (MultiStateView) LayoutInflater.from(context).inflate(resLayout, null);
    }

    public MultiStateView getMultiStateView() {
        return multiStateView;
    }

    public void setState(int i) {
        if (multiStateView != null) {
            multiStateView.setViewState(i);
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        button = (Button) multiStateView.getView(MultiStateView.VIEW_STATE_ERROR).findViewById(R.id.retry);
        button.setOnClickListener(onClickListener);
    }

}
