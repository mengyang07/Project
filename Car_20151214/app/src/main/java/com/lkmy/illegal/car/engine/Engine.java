package com.lkmy.illegal.car.engine;

import com.lkmy.illegal.car.model.CarLllegalList;
import com.lkmy.illegal.car.model.weather.Weather;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:15/9/17 下午2:01
 * 描述:
 */
public interface Engine {

    @GET("api/json/defaultdata.json")
    Call<CarLllegalList> loadInitDatas();

    @GET("api/json/newdata{pageNumber}.json")
    Call<CarLllegalList> loadNewData(@Path("pageNumber") int pageNumber);

    @GET("api/json/moredata{pageNumber}.json")
    Call<CarLllegalList> loadMoreData(@Path("pageNumber") int pageNumber);

    @GET("http://api.map.baidu.com/telematics/v3/weather")
    Call<Weather> loadWeather(@Query("location") String city,@Query("ak") String ak,@Query("output") String output);

}