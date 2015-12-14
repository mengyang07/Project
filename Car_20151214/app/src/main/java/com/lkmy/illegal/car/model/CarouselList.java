package com.lkmy.illegal.car.model;

import java.util.List;

/**
 * Created by 凯 on 2015/11/1.
 */
public class CarouselList implements DisplayableItem {

    private List<Carousel> carouselList;

    public CarouselList(List<Carousel> carouselList) {
        this.carouselList = carouselList;
    }

    public List<Carousel> getCarouselList() {
        return carouselList;
    }

    public void setCarouselList(List<Carousel> carouselList) {
        this.carouselList = carouselList;
    }

    @Override
    public String toString() {
        return "CarouselList{" +
                "carouselList=" + carouselList +
                '}';
    }
}
