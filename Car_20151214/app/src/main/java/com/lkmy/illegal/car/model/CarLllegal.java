package com.lkmy.illegal.car.model;

/**
 * Created by 凯 on 2015/10/27.
 */
public class CarLllegal implements DisplayableItem {
    private String time;
    private String address;
    private String content;
    private String legalnum;
    private String price;
    private String id;
    private int score;

    public CarLllegal(String time, String address, String content) {
        this.time = time;
        this.address = address;
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLegalnum() {
        return legalnum;
    }

    public void setLegalnum(String legalnum) {
        this.legalnum = legalnum;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "CarLllegal{" +
                "time='" + time + '\'' +
                ", address='" + address + '\'' +
                ", content='" + content + '\'' +
                ", legalnum=" + legalnum +
                ", price='" + price + '\'' +
                ", id='" + id + '\'' +
                ", score=" + score +
                '}';
    }
}
