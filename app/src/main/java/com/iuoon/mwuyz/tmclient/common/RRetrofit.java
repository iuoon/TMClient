package com.iuoon.mwuyz.tmclient.common;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;


/**
 * Created by mwuyz on 2016/8/17.
 */
public abstract  class RRetrofit {
    public static String BASE_URL = "http://192.168.1.118:8080";
    private static final int DEFAULT_TIMEOUT = 3;


    public static <T> T create(final Class<T> cls) {
        Retrofit.Builder builder = new Retrofit.Builder();
        OkHttpClient.Builder httpBuilder = new OkHttpClient.Builder();
        //设置超时时间
        OkHttpClient client=httpBuilder.readTimeout(DEFAULT_TIMEOUT, TimeUnit.MINUTES)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.MINUTES).writeTimeout(DEFAULT_TIMEOUT, TimeUnit.MINUTES) //设置超时
                .build();
        Retrofit retrofit = builder
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(cls);
    }
}
