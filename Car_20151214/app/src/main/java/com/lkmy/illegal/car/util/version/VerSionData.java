package com.lkmy.illegal.car.util.version;

import android.content.Context;
import android.content.pm.PackageInfo;

/**
 * 作者:李凯
 * 创建时间:2015/11/26 3:37
 * 描述:
 */
public class VerSionData {

    /**
     * 软件-版本
     *
     * @param context
     * @return
     */
    public static String getAppVersion(Context context) {

        String versionName = "";
        try {
            PackageInfo pkgInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            versionName = pkgInfo.versionName;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return versionName;
    }

    public static int getAppVersionCode(Context context) {

        int versionCode = -1;
        try {
            PackageInfo pkgInfo = context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), 0);
            versionCode = pkgInfo.versionCode;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return versionCode;
    }
}
