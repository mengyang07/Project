package com.lkmy.illegal.car;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;


/**
 * 作者:李凯
 * 创建时间:2015/11/24 00:15
 * 描述:
 */
public class BgService extends Service {


    @Override
    public void onCreate() {
        super.onCreate();

    }


    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
