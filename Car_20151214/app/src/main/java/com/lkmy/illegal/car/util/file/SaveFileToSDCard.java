package com.lkmy.illegal.car.util.file;


import com.lkmy.illegal.car.App;

import java.io.File;
import java.io.IOException;

/**
 * 作者:李凯
 * 创建时间:2015/11/24 00:15
 * 描述:
 */
public class SaveFileToSDCard {

    private FileHelper fileHelper;

    /**
     * 下载文件夹名称
     */
    private String FILESAVEPATH = "MUDOWN";
    /**
     * 文件路径
     */
    private String urlPath;

    public SaveFileToSDCard() {
        this.fileHelper = new FileHelper(App.getInstance());
    }

    public String createApk(String apkName) {
        this.fileHelper.createSDDir(this.FILESAVEPATH);
        if (fileHelper.SDCardState()) {
            if (this.fileHelper.isFileExist(this.FILESAVEPATH + File.separator + apkName)) {
                this.fileHelper.delSDFile(this.FILESAVEPATH + File.separator + apkName);
            }
            try {
                this.urlPath = this.fileHelper.createSDFile(this.FILESAVEPATH + File.separator + apkName).getPath();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                fileHelper.creatDataDir(this.FILESAVEPATH);
                this.urlPath = this.fileHelper.creatDataFile(this.FILESAVEPATH + File.separator + apkName).getPath();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return this.urlPath;
    }

}