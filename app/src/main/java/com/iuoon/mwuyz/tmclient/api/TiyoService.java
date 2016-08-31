package com.iuoon.mwuyz.tmclient.api;

import com.iuoon.mwuyz.tmclient.common.TransVo;
import com.iuoon.mwuyz.tmclient.model.TWNotice;
import com.iuoon.mwuyz.tmclient.model.TWUser;

import java.util.List;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;
/**
 * @GET 表明方法是 get请求
 * "/api" 请求的接口
 * @Query 表示这是一个参数
 * @Description :通信请求api接口
 * Created by iuoon on 2016/8/17.
 * @version  v1.0.0
 */
public interface TiyoService {

    // 登陆
    @POST("/login")
    Observable<TransVo<TWUser>> login(@Query("userName") String userName, @Query("password") String password);

    @POST("/register")
    Observable<TransVo<TWUser>> register(@Body TWUser user);

    @GET("/getNotice")
    Observable<TransVo<List<TWNotice>>> getNotice();

}
