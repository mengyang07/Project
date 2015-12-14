package com.lkmy.illegal.car.model;

/**
 * 作者:李凯
 * 创建时间:2015/11/26 3:47
 * 描述:
 */
public class VersionDownload {

    private int versionCode;
    private String downloadUrl;
    private String apkName;

    public VersionDownload(int versionCode, String downloadUrl, String apkName) {
        this.versionCode = versionCode;
        this.downloadUrl = downloadUrl;
        this.apkName = apkName;
    }

    public String getApkName() {
        return apkName;
    }

    public void setApkName(String apkName) {
        this.apkName = apkName;
    }

    public int getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(int versionCode) {
        this.versionCode = versionCode;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }
}
