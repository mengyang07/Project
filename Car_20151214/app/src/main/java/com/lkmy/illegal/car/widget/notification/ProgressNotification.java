package com.lkmy.illegal.car.widget.notification;


import android.app.Notification;

import com.lkmy.illegal.car.App;
import com.lkmy.illegal.car.R;

/**
 * 作者:李凯
 * 创建时间:2015/11/24 00:15
 * 描述:
 */
public class ProgressNotification extends BaseNotification {


    private int progress;
    private final int NOTIFYCATIONID = 1001;


    public void showProgressNotify() {
        mBuilder.setContentTitle("正在下载:" + App.getInstance().getResources().getString(R.string.app_name))
                .setSmallIcon(R.drawable.ic_launcher)
                .setContentIntent(getDefalutIntent(0))
                .setTicker("开始下载");// 通知首次出现在通知栏，带上升动画效果的
        Notification mNotification = mBuilder.build();
        mNotification.flags = Notification.FLAG_ONGOING_EVENT;//
        // 确定进度的
        mBuilder.setProgress(100, progress, false); // 这个方法是显示进度条 设置为true就是不确定的那种进度条效果
        mNotificationManager.notify(NOTIFYCATIONID, mNotification);
    }

    public void clear() {
        clearNotify(NOTIFYCATIONID);

    }

    /**
     * 设置下载进度
     */
    public void updateNotification(int progress) {
        Notification mNotification = mBuilder.build();
        mNotification.flags = Notification.FLAG_ONGOING_EVENT;//
        mBuilder.setProgress(100, progress, false); // 这个方法是显示进度条
        mBuilder.setContentText(progress + "%");
        mNotificationManager.notify(NOTIFYCATIONID, mNotification);
    }


}
