package com.iuoon.mwuyz.tmclient.api;

import com.iuoon.mwuyz.tmclient.common.MsgResponse;
import com.iuoon.mwuyz.tmclient.common.TransVo;

import retrofit.Call;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;
import rx.Observable;
/**
 * @GET 表明方法是 get请求
 * "/api" 请求的接口,请注意前面的/符号
 * @Query 表示这是一个参数
 * Call<ResponseBody> :Call是必须的,ResponseBody是Retrofit默认的返回数据类型,也就是String体
 * @Description :通信请求api接口
 * Created by iuoon on 2016/8/17.
 * @version  v1.0.0
 */
public interface TiyoService {

    // 登陆
    @POST("/login")
    Call<MsgResponse> login(@Body TransVo transVo);

    // 下发短信验证码
    @POST("/getCheckCode")
    Call<MsgResponse> getCheckCode(@Query("tel") String telno);

    // 获取新闻资讯
    @GET("/getNews")
    Call<MsgResponse> getNews(@Query("type") String type);

    // 获取开奖公告
    @POST("/getNotice")
    Observable<MsgResponse> getNotice();



}
