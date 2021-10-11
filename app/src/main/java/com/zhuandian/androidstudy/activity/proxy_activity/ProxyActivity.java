package com.zhuandian.androidstudy.activity.proxy_activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.zhuandian.androidstudy.R;
import com.zhuandian.androidstudy.activity.proxy_activity.dao.UserDaoImpl;
import com.zhuandian.androidstudy.activity.proxy_activity.proxy.UserDaoProxy;
public class ProxyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proxy);

        //目标对象
        UserDaoImpl target = new UserDaoImpl();
        //代理对象,把目标对象传给代理对象,建立代理关系
        UserDaoProxy proxy = new UserDaoProxy(target);
        proxy.save("xiaoming"); //执行的是代理的方法
        proxy.save("xiaohong");
    }
}
