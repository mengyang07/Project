package com.lkmy.illegal.car.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import java.io.File;

/**
 * 作者:李凯
 * 创建时间:2015/11/26 3:25
 * 描述:
 */
public class InstallApk {
    public static void Install(String urlPath, Context context) {
        Intent apkIntent = new Intent();
        apkIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        apkIntent.setAction(Intent.ACTION_VIEW);
        File apkFile = new File(urlPath);
        Uri uri = Uri.fromFile(apkFile);
        apkIntent.setDataAndType(uri,
                "application/vnd.android.package-archive");
        context.startActivity(apkIntent);
    }

}
