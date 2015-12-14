package com.lkmy.illegal.car.widget.notification;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;

import com.lkmy.illegal.car.App;

/**
 * 作者:李凯
 * 创建时间:2015/11/27 0:52
 * 描述:
 */
public class BaseNotification {
    protected NotificationManager mNotificationManager;
    protected NotificationCompat.Builder mBuilder;


    public BaseNotification() {
        initNotifycation();
    }

    private void initNotifycation() {
        mNotificationManager = (NotificationManager) App.getInstance().getSystemService(App.getInstance().NOTIFICATION_SERVICE);
        mBuilder = new NotificationCompat.Builder(App.getInstance());
        mBuilder.setWhen(System.currentTimeMillis());
    }

    /**
     * 清除当前创建的通知栏
     */
    public void clearNotify(int notifyId) {
        mNotificationManager.cancel(notifyId);//删除一个特定的通知ID对应的通知
    }

    /**
     * 清除所有通知栏
     */
    public void clearAllNotify() {
        mNotificationManager.cancelAll();// 删除你发的所有通知
    }

    /**
     * @获取默认的pendingIntent,为了防止2.3及以下版本报错
     * @flags属性: 在顶部常驻:Notification.FLAG_ONGOING_EVENT
     * 点击去除： Notification.FLAG_AUTO_CANCEL
     */
    public PendingIntent getDefalutIntent(int flags) {
        PendingIntent pendingIntent = this.getActivityIntent(flags, new Intent());
        return pendingIntent;
    }

    public PendingIntent getActivityIntent(int flags, Intent intent) {
        PendingIntent pendingIntent = PendingIntent.getActivity(
                App.getInstance(), 1, intent, flags);
        return pendingIntent;
    }
}
