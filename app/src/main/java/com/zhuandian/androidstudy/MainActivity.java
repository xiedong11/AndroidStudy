package com.zhuandian.androidstudy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import com.zhuandian.androidstudy.activity.AnnotationActivity;
import com.zhuandian.androidstudy.activity.layout_activity.LayoutMainActivity;
import com.zhuandian.androidstudy.activity.notification_activity.NotificationActivity;
import com.zhuandian.androidstudy.view_activity.ViewMainActivity;

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
        }
    }
}
