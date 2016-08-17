package com.iuoon.mwuyz.tmclient.common;

import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;



/**
 * Created by mwuyz on 2016/8/17.
 */
public abstract  class RRetrofit {
    public static String BASE_URL = "http://192.168.1.118:8080";
    public static <T> T create(final Class<T> cls) {
        Retrofit.Builder builder = new Retrofit.Builder();
        Retrofit retrofit = builder
                .baseUrl(BASE_URL)
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(cls);
    }
}
