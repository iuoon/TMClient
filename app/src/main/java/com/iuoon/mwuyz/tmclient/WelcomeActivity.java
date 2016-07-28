package com.iuoon.mwuyz.tmclient;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        /**标题是属于View的，所以窗口所有的修饰部分被隐藏后标题依然有效,需要去掉标题**/
        //   requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide(); //隐藏标题栏
        setContentView(R.layout.activity_welcome);

        Timer timer = new Timer(true);
        TimerTask hello = new TimerTask(){
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                finish();  //不加这一句，按回退键就会回到欢迎界面不合理。
            }
        };
        timer.schedule(hello, 3000); //延迟3000毫秒执行
    }
}
