package com.lkmy.illegal.car.logic;

import android.net.Uri;

import com.lkmy.illegal.car.App;
import com.lkmy.illegal.car.widget.notification.ProgressNotification;
import com.lkmy.illegal.car.util.InstallApk;
import com.lkmy.illegal.car.util.file.SaveFileToSDCard;
import com.thin.downloadmanager.DownloadManager;
import com.thin.downloadmanager.DownloadRequest;
import com.thin.downloadmanager.DownloadStatusListener;
import com.thin.downloadmanager.ThinDownloadManager;

/**
 * 作者:李凯
 * 创建时间:2015/11/26 3:07
 * 描述:
 */
public class DownloaderForApk implements DownloadStatusListener {

    private ThinDownloadManager downloadManager;
    private static final int DOWNLOAD_THREAD_POOL_SIZE = 4;
    private String downloadUrl;
    private int downloadId = 0;
    private DownloadRequest downloadRequest;
    private ProgressNotification progressNotification;
    private String urlPath;

    public DownloaderForApk(String downloadUrl, String apkName) {
        this.downloadUrl = downloadUrl;
        SaveFileToSDCard sv = new SaveFileToSDCard();
        this.urlPath = sv.createApk(apkName);
        this.init();
        this.initDownload();

    }

    private void init() {
        this.downloadManager = new ThinDownloadManager(DOWNLOAD_THREAD_POOL_SIZE);
    }

    private void initDownload() {
        Uri downloadUri = Uri.parse(downloadUrl);
        Uri destinationUri = Uri.parse(urlPath);
        this.downloadRequest = new DownloadRequest(downloadUri)
                .setDestinationURI(destinationUri).setPriority(DownloadRequest.Priority.HIGH)
                .setDownloadListener(this);

    }

    public void start() {
        progressNotification = new ProgressNotification();
        if (downloadManager.query(downloadId) == DownloadManager.STATUS_NOT_FOUND) {
            downloadId = downloadManager.add(downloadRequest);
        }
        progressNotification.showProgressNotify();
    }

    public void closeDownload() {
        downloadManager.release();
        downloadRequest.cancel();
    }

    @Override
    public void onDownloadComplete(int id) {
        progressNotification.clear();
        InstallApk.Install(urlPath, App.getInstance());

    }

    @Override
    public void onDownloadFailed(int id, int errorCode, String errorMessage) {

    }

    @Override
    public void onProgress(int id, long totalBytes, int progress) {
        progressNotification.updateNotification(progress);
    }


}
