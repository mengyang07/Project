package com.lkmy.illegal.car.model.weather;

/**
 * 作者:李凯
 * 创建时间:2015/12/11 23:19
 * 描述:
 */
public class WeatherData {
    private String date;
    private String dayPictureUrl;
    private String nightPictureUrl;
    private String weather;
    private String wind;
    private String temperature;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDayPictureUrl() {
        return dayPictureUrl;
    }

    public void setDayPictureUrl(String dayPictureUrl) {
        this.dayPictureUrl = dayPictureUrl;
    }

    public String getNightPictureUrl() {
        return nightPictureUrl;
    }

    public void setNightPictureUrl(String nightPictureUrl) {
        this.nightPictureUrl = nightPictureUrl;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "date='" + date + '\'' +
                ", dayPictureUrl='" + dayPictureUrl + '\'' +
                ", nightPictureUrl='" + nightPictureUrl + '\'' +
                ", weather='" + weather + '\'' +
                ", wind='" + wind + '\'' +
                ", temperature='" + temperature + '\'' +
                '}';
    }
}
