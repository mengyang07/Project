package com.lkmy.illegal.car.model;

import java.util.List;

/**
 * Created by 凯 on 2015/10/27.
 */
public class CarLllegalList {
    private int error;
    private String msg;
    private int canfee;
    private int onefee;
    private String usercarid;
    private List<CarLllegal> data;

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCanfee() {
        return canfee;
    }

    public void setCanfee(int canfee) {
        this.canfee = canfee;
    }

    public int getOnefee() {
        return onefee;
    }

    public void setOnefee(int onefee) {
        this.onefee = onefee;
    }

    public String getUsercarid() {
        return usercarid;
    }

    public void setUsercarid(String usercarid) {
        this.usercarid = usercarid;
    }

    public List<CarLllegal> getData() {
        return data;
    }

    public void setData(List<CarLllegal> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CarLllegalList{" +
                "error=" + error +
                ", msg='" + msg + '\'' +
                ", canfee=" + canfee +
                ", onefee=" + onefee +
                ", usercarid=" + usercarid +
                ", data=" + data +
                '}';
    }
}

