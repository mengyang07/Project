package com.lkmy.illegal.car.model;

/**
 * 作者:李凯
 * 创建时间:2015/11/27 1:03
 * 描述:
 */
public class PushNotify {
    private int id;
    private String content;
    private String title;
    private String ticker;
    private String openUrl;

    public PushNotify(int id, String title, String content, String ticker, String openUrl) {
        this.id = id;
        this.content = content;
        this.title = title;
        this.ticker = ticker;
        this.openUrl = openUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public String getOpenUrl() {
        return openUrl;
    }

    public void setOpenUrl(String openUrl) {
        this.openUrl = openUrl;
    }
}
