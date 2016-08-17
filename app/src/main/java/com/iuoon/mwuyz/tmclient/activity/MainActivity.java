package com.iuoon.mwuyz.tmclient.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.iuoon.mwuyz.tmclient.R;
import com.iuoon.mwuyz.tmclient.api.TiyoService;
import com.iuoon.mwuyz.tmclient.common.MsgResponse;
import com.iuoon.mwuyz.tmclient.common.RRetrofit;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /*Retrofit请求*/
    public void getNews(){
        TiyoService service= RRetrofit.create(TiyoService.class);
        Call<MsgResponse> news = service.getNews("1");
        news.enqueue(new Callback<MsgResponse>() {
            @Override
            public void onResponse(Response<MsgResponse> response, Retrofit retrofit) {
                Log.d("getNews<-----", response.body().toString());
            }

            @Override
            public void onFailure(Throwable t) {
                Log.e("getNews error----->", t.toString());
            }
        });
    }

    /*此处用Rx*/
    public void getNotice(){
        TiyoService service= RRetrofit.create(TiyoService.class);
        service.getNotice()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<MsgResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(MsgResponse msgResponse) {
                        Log.d("getNotice<-----", msgResponse.getBody());
                    }
                });

    }

}
