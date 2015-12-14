package com.lkmy.illegal.car.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.lkmy.illegal.car.R;
import com.lkmy.illegal.car.util.ThreadUtil;
import com.lkmy.illegal.car.util.version.StoredVersionData;


/**
 * 作者:李凯
 * 创建时间:2015/11/24 0:52
 * 描述:通过版本号(StoredVersionData类)跳转Activity
 * LoginAcitivity 首次安装-首次启动、覆盖安装-首次启动时启动
 * MainActivity 已安装-二次启动时启动
 */
public class OpenActivity extends BaseActivity {


    private boolean isFirstOpen = false;
    private final int MAIN_ACTIVITY_KEY = 1;
    private final int LOGIN_ACTIVITY_KEY = 2;
    private TextView button;

    /**
     * 显示广告延时启动 并在右上角有跳过按钮
     * button通过ThreadUtil 显示秒数
     */
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            openActivity(MAIN_ACTIVITY_KEY);
            return;
        }
    };



    @Override
    protected void initView(Bundle savedInstanceState) {
        setContentView(R.layout.activity_open);
        ImageView imageView = getViewById(R.id.activity_open_imageview);
        imageView.setBackgroundResource(R.drawable.dd);
        button = getViewById(R.id.activity_open_button);
    }

    @Override
    protected void setListener() {
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ThreadUtil.closeInUIThread(runnable);
        openActivity(MAIN_ACTIVITY_KEY);
    }


    @Override
    protected void processLogic(Bundle savedInstanceState) {
        markOpenApp();
        if (isFirstOpen) {
            openActivity(LOGIN_ACTIVITY_KEY);
        } else {
            ThreadUtil.runInUIThread(runnable, 3000);
        }
    }


    private void markOpenApp() {
        if (isFirstOpen)
            return;
        if (StoredVersionData.getThis().isFirstOpen()) {
            isFirstOpen = true;
        }
    }

    protected void openActivity(int i) {
        Intent intent;
        switch (i) {
            case MAIN_ACTIVITY_KEY:
                intent = new Intent(mApp, MainActivity.class);
                break;
            case LOGIN_ACTIVITY_KEY:
                intent = new Intent(mApp, LoginActivity.class);
                break;
            default:
                intent = new Intent(mApp, MainActivity.class);
                break;
        }
        startActivity(intent);
        finish();
    }

}
