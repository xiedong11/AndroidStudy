package com.zhuandian.androidstudy;

import android.app.Application;

/**
 * desc :
 * author：xiedong
 * date：2019/11/11
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println(Thread.currentThread().getName()+"--555555-----------------------");
        System.out.println(Thread.currentThread().getName()+"--555555-----------------------");
        System.out.println(Thread.currentThread().getName()+"--555555-----------------------");

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"--555555-----------------------");
            }
        }).start();
    }
}
