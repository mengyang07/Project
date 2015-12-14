package com.lkmy.illegal.car.logic;

import android.content.Context;

import com.lkmy.illegal.car.App;
import com.lkmy.illegal.car.model.VersionDownload;
import com.lkmy.illegal.car.widget.dialog.UpdateDialog;
import com.lkmy.illegal.car.util.version.VerSionData;

/**
 * 作者:李凯
 * 创建时间:2015/11/26 3:30
 * 描述:
 */
public class AppUpdate implements UpdateDialog.DialogCallback {

    private VersionDownload appVersion;

    public AppUpdate(VersionDownload versionModel, Context context) {
        this.appVersion = versionModel;
        if (versionModel.getVersionCode() > VerSionData.getAppVersionCode(App.getInstance())) {
            new UpdateDialog(context)
                    .setButtonText("马上更新", "取消")
                    .setDialogText("更新说明", "1、测试111\n2、测试222")
                    .setDialogCallback(this)
                    .show();
        }
    }

    public void updateVersion() {
        DownloaderForApk versionUpdate = new DownloaderForApk(appVersion.getDownloadUrl(), appVersion.getApkName());
        versionUpdate.start();
    }


    @Override
    public void callback() {
        updateVersion();
    }


}
