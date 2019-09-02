package com.zhuandian.androidstudy.activity.mvp;

import android.os.SystemClock;

/**
 * desc :
 * author：xiedong
 * date：2019/8/14
 */
public class DemoModel {
    public void onRequestData(CallBack<Entity> cllBack) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(3000);
                cllBack.onSuccess(new Entity("响应数据"));
            }
        }).start();
    }
}
