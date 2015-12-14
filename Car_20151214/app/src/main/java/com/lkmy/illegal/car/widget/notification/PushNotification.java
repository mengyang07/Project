package com.lkmy.illegal.car.widget.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;

import com.lkmy.illegal.car.App;
import com.lkmy.illegal.car.R;
import com.lkmy.illegal.car.model.PushNotify;
import com.lkmy.illegal.car.ui.activity.WebActivity;

/**
 * 作者:李凯
 * 创建时间:2015/11/27 0:52
 * 描述:
 */
public class PushNotification extends BaseNotification {
    private PushNotify pushNotify;

    public PushNotification(PushNotify pushNotify) {
        this.pushNotify = pushNotify;
    }

    public void showProgressNotify() {

        Intent intent = new Intent(App.getInstance(), WebActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setData(Uri.parse(pushNotify.getOpenUrl()));

        mBuilder.setContentTitle(pushNotify.getTitle())
                .setContentText(pushNotify.getContent())
                .setContentIntent(getActivityIntent(PendingIntent.FLAG_UPDATE_CURRENT, intent))
                .setSmallIcon(R.drawable.ic_launcher)
                .setTicker(pushNotify.getTicker())// 通知首次出现在通知栏，带上升动画效果的
                .setAutoCancel(true);
        Notification mNotification = mBuilder.build();
        // 确定进度的
        mNotificationManager.notify(pushNotify.getId(), mNotification);
    }


}
