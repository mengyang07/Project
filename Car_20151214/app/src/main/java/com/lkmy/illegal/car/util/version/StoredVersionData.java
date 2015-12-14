package com.lkmy.illegal.car.util.version;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;


/**
 * 作者:李凯
 * 创建时间:2015/11/15 00:15
 * 描述:根据软件版本号来判断启动模式(首次安装-首次启动、覆盖安装-首次启动、已安装-二次启动)
 */
public class StoredVersionData {

    public static final int LMODE_NEW_INSTALL = 1;  //首次安装-首次启动
    public static final int LMODE_UPDATE = 2;       //覆盖安装-首次启动
    public static final int LMODE_AGAIN = 3;        //已安装-二次启动

    private int launchMode = LMODE_AGAIN; // 启动-模式

    private static StoredVersionData instance;

    private SharedPreferences share; // 一般信息

    public static StoredVersionData getThis() {

        if (instance == null)
            instance = new StoredVersionData();

        return instance;
    }

    /**
     * -------启动状态-------
     * 标记-打开app,用于产生-是否首次打开
     */
    public void markOpenApp(Context context) {

        share = PreferenceManager.getDefaultSharedPreferences(context);
        String lastVersion = share.getString("lastVersion", "");
        String thisVersion = VerSionData.getAppVersion(context);

        // 首次启动
        if (TextUtils.isEmpty(lastVersion)) {
            launchMode = LMODE_NEW_INSTALL;
            share.edit().putString("lastVersion", thisVersion).commit();
        }
        // 更新
        else if (!thisVersion.equals(lastVersion)) {
            launchMode = LMODE_UPDATE;
            share.edit().putString("lastVersion", thisVersion).commit();
        }
        // 二次启动(版本未变)
        else
            launchMode = LMODE_AGAIN;
    }

    public int getLaunchMode() {

        return launchMode;
    }

    /**
     * 首次打开,新安装、覆盖(版本号不同)
     *
     * @return
     */
    public boolean isFirstOpen() {

        return launchMode != LMODE_AGAIN;
    }


}

