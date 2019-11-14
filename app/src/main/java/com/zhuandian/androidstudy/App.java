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


        try {

            //为了避免app启动慢，尽量不要在Application的入口处做太多的耗时操作
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
