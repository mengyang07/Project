package com.lkmy.illegal.car.model;

/**
 * Created by 凯 on 2015/10/31.
 */
public class Carousel {

    private String imageTitle;
    private String openUrl;
    private String imageUrl;

    public Carousel(String imageTitle, String openUrl, String imageUrl) {
        this.imageTitle = imageTitle;
        this.openUrl = openUrl;
        this.imageUrl = imageUrl;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public String getOpenUrl() {
        return openUrl;
    }

    public void setOpenUrl(String openUrl) {
        this.openUrl = openUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Carousel{" +
                "imageTitle='" + imageTitle + '\'' +
                ", openUrl='" + openUrl + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
