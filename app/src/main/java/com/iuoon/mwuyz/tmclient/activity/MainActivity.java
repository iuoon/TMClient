package com.iuoon.mwuyz.tmclient.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.iuoon.mwuyz.tmclient.R;
import com.iuoon.mwuyz.tmclient.api.TiyoService;
import com.iuoon.mwuyz.tmclient.common.RRetrofit;
import com.iuoon.mwuyz.tmclient.common.TransVo;
import com.iuoon.mwuyz.tmclient.model.TWNotice;
import com.iuoon.mwuyz.tmclient.model.TWUser;


import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 测试rxjava+Retrofit+jackson
 */
public class MainActivity extends AppCompatActivity {

    private TiyoService service= RRetrofit.create(TiyoService.class);

    private EditText etext;
    private TextView ttext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etext=(EditText) findViewById(R.id.editText);
        ttext=(TextView) findViewById(R.id.textView3);
        login();
        getNotice();
    }



    /*此处用RxJava+Retrofit */
    public void login(){

        service.login("iuoon","123456")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( new Subscriber<TransVo<TWUser>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("login error----->", e.toString());
                    }

                    @Override
                    public void onNext(TransVo<TWUser> lresp) {
                        Log.d("login success----->",lresp.getCode()+"---"+ lresp.getMessage());
                        etext.setText(lresp.getParams().getName());
                    }


                });

    }

    public void getNotice(){

        service.getNotice()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe( new Subscriber<TransVo<List<TWNotice>>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("getNotice error----->", e.toString());
                    }

                    @Override
                    public void onNext(TransVo<List<TWNotice>> lresp) {
                        Log.d("getNotice success----->",lresp.getCode()+"---"+ lresp.getMessage());
                        List<TWNotice> noticeList=lresp.getParams();
                        Log.d("title:",noticeList.get(0).getNoticeTitle());
                        ttext.setText(noticeList.get(0).getNoticeTitle());
                    }

                });

    }

}
