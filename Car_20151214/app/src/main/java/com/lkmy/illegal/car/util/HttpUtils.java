package com.lkmy.illegal.car.util;

/**
 * 作者:李凯
 * 创建时间:2015/12/11 1:25
 * 描述:
 */
public interface HttpUtils<T,H> {

    public String doPost(String url, T params);

    public String doGet(String url, T params);

    public void shutDownClient();

    public H getHeader() ;
}
