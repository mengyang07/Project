package com.lkmy.illegal.car;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by 丹 on 2015/11/07.
 */
public class BgReceiver extends BroadcastReceiver {
    static final String ACTION = "android.intent.action.BOOT_COMPLETED";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(ACTION)) {
            context.startService(new Intent(context, BgService.class));//启动倒计时服务
            //这边可以添加开机自动启动的应用程序代码
        }
    }
}
