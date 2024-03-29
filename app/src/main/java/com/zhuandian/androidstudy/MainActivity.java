package com.zhuandian.androidstudy;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import com.zhuandian.androidstudy.activity.AopTestActivity;
import com.zhuandian.androidstudy.activity.AnnotationActivity;
import com.zhuandian.androidstudy.activity.GreenDaoActivity;
import com.zhuandian.androidstudy.activity.RxjavaActivity;
import com.zhuandian.androidstudy.activity.SecondFloorActivity;
import com.zhuandian.androidstudy.activity.ThreadPoolTestActivity;
import com.zhuandian.androidstudy.activity.darg_list.DragRecyclerViewActivity;
import com.zhuandian.androidstudy.activity.layout_activity.LayoutMainActivity;
import com.zhuandian.androidstudy.activity.notification_activity.NotificationActivity;
import com.zhuandian.androidstudy.activity.proxy_activity.ProxyActivity;
import com.zhuandian.androidstudy.activity.view_activity.ViewMainActivity;

import io.flutter.view.FlutterMain;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_linear).setOnClickListener(this);
        findViewById(R.id.btn_view).setOnClickListener(this);
        findViewById(R.id.btn_notification).setOnClickListener(this);
        findViewById(R.id.btn_flutter_aar).setOnClickListener(this);
        findViewById(R.id.btn_annotation).setOnClickListener(this);
        findViewById(R.id.btn_aop).setOnClickListener(this);
        findViewById(R.id.btn_Rxjava).setOnClickListener(this);
        findViewById(R.id.btn_second_floor).setOnClickListener(this);
        findViewById(R.id.btn_thread_pool).setOnClickListener(this);
        findViewById(R.id.btn_proxy).setOnClickListener(this);
        findViewById(R.id.btn_green_dao).setOnClickListener(this);
        findViewById(R.id.btn_drag_recyclerview).setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_linear:
                startActivity(new Intent(MainActivity.this, LayoutMainActivity.class));
                break;
            case R.id.btn_view:
                startActivity(new Intent(MainActivity.this, ViewMainActivity.class));
                break;
            case R.id.btn_notification:
                startActivity(new Intent(MainActivity.this, NotificationActivity.class));
                break;
            case R.id.btn_flutter_aar:
                FlutterMain.startInitialization(this);
                startActivity(new Intent(MainActivity.this, com.zhuandian.flutter_app.MainActivity.class));
                break;
            case R.id.btn_annotation:
                startActivity(new Intent(MainActivity.this, AnnotationActivity.class));
                break;
            case R.id.btn_aop:
                startActivity(new Intent(MainActivity.this, AopTestActivity.class));
                break;
            case R.id.btn_Rxjava:
                startActivity(new Intent(MainActivity.this, RxjavaActivity.class));
                break;
            case R.id.btn_second_floor:
                startActivity(new Intent(MainActivity.this, SecondFloorActivity.class));
                break;
            case R.id.btn_thread_pool:
                startActivity(new Intent(MainActivity.this, ThreadPoolTestActivity.class));
                break;
            case R.id.btn_proxy:
                startActivity(new Intent(MainActivity.this, ProxyActivity.class));
                break;
            case R.id.btn_green_dao:
                startActivity(new Intent(MainActivity.this, GreenDaoActivity.class));
                break;
            case R.id.btn_drag_recyclerview:
                startActivity(new Intent(MainActivity.this, DragRecyclerViewActivity.class));
                break;

        }
    }
}
