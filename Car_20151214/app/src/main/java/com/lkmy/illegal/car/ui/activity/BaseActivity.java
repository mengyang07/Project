package com.lkmy.illegal.car.ui.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;

import com.baidu.mobstat.StatService;
import com.lkmy.illegal.car.App;
import com.lkmy.illegal.car.engine.Engine;
import com.lkmy.illegal.car.util.ToastUtil;


/**
 * 作者:李凯
 * 创建时间:2015/11/13 00:15
 * 描述:
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {
    protected String TAG;
    protected App mApp;
    protected Engine mEngine;
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TAG = this.getClass().getSimpleName();
        mApp = App.getInstance();
        mEngine = mApp.getEngine();
        initView(savedInstanceState);
        setListener();
        processLogic(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        StatService.onResume(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        StatService.onPause(this);
    }

    /**
     * 拦截返回键
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            onBackKeyDown();
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }

    protected void onBackKeyDown() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            showToast("再按一次退出程序");
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }


    /**
     * 查找View
     *
     * @param id   控件的id
     * @param <VT> View类型
     * @return
     */
    protected <VT extends View> VT getViewById(@IdRes int id) {

        return (VT) findViewById(id);
    }

    /**
     * 初始化布局以及View控件
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
     * 需要处理点击事件时，重写该方法
     *
     * @param v
     */
    public  void onClick(View v){

    }

    protected void showToast(String text) {

        ToastUtil.show(text);
    }


}