package com.lkmy.illegal.car.model.weather;

import java.util.List;

/**
 * 作者:李凯
 * 创建时间:2015/12/11 23:20
 * 描述:
 */
public class Weather {

    private String error;
    private String status;
    private String date;
    private List<WeatherResults> results;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public List<WeatherResults> getResults() {
        return results;
    }

    public void setResults(List<WeatherResults> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "error='" + error + '\'' +
                ", status='" + status + '\'' +
                ", date='" + date + '\'' +
                ", results=" + results +
                '}';
    }
}
