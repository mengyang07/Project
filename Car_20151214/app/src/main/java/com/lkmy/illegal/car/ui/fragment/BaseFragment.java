package com.lkmy.illegal.car.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.mobstat.StatService;
import com.lkmy.illegal.car.App;
import com.lkmy.illegal.car.engine.Engine;
import com.lkmy.illegal.car.ui.activity.BaseActivity;
import com.lkmy.illegal.car.util.ToastUtil;
import com.lkmy.illegal.car.widget.MultiStateViewManager;
import com.lkmy.library.loadingview.MultiStateView;


/**
 * 作者:李凯
 * 创建时间:2015/11/13 00:15
 * 描述:
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {
    protected String TAG;
    protected App mApp;
    protected View mContentView;
    protected Engine mEngine;
    protected BaseActivity mActivity;
    protected MultiStateViewManager multiStateViewManager;
    protected MultiStateView multiStateView;
    protected boolean isVisible;


    public void onAttach(Context context) {
        super.onAttach(context);
        TAG = this.getClass().getSimpleName();
        mApp = App.getInstance();
        mActivity = (BaseActivity) context;
        mEngine = mApp.getEngine();
        multiStateViewManager = new MultiStateViewManager(context);
        multiStateView = multiStateViewManager.getMultiStateView();
        multiStateViewManager.setOnClickListener(this);
    }

    @Override
    public void onPause() {
        StatService.onPause(this);
        super.onPause();
    }


    @Override
    public void onResume() {
        StatService.onResume(this);
        super.onResume();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // 避免多次从xml中加载布局文件
        if (mContentView == null) {
            initView(savedInstanceState);
            setListener();
            processLogic(savedInstanceState);

        } else {
            ViewGroup parent = (ViewGroup) mContentView.getParent();
            if (parent != null) {
                parent.removeView(mContentView);
            }
        }
        return multiStateView;
    }

    protected void setContentView(@LayoutRes @NonNull int layoutResID) {
        mContentView = LayoutInflater.from(mApp).inflate(layoutResID, null);
        if (multiStateView!=null)
            multiStateView.addView(mContentView);

    }

    protected void setContentView(@NonNull View view) {
        mContentView = view;
        if (multiStateView!=null)
            multiStateView.addView(mContentView);

    }

    /**
     * 初始化View控件
     */
    protected abstract void initView(Bundle savedInstanceState);

    /**
     * 给View控件添加事件监听器
     */
    protected abstract void setListener();

    /**
     * 处理业务逻辑，状态恢复等操作
     *
     * @param savedInstanceState
     */
    protected abstract void processLogic(Bundle savedInstanceState);

    /**
     * 当fragment对用户可见时，会调用该方法，可在该方法中懒加载网络数据
     */
    protected void onVisible() {
        load();

    }

    protected abstract void load();

    protected void onInvisible() {

    }


    /**
     * 查找View
     *
     * @param id   控件的id
     * @param <VT> View类型
     * @return
     */
    protected <VT extends View> VT getViewById(@IdRes @NonNull int id) {
        return (VT) mContentView.findViewById(id);
    }

    protected void showToast(String text) {
        ToastUtil.show(text);
    }

    @Override
    public void onClick(View v) {
        load();

    }

}