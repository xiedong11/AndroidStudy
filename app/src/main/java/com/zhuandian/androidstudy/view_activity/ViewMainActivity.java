package com.zhuandian.androidstudy.view_activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.zhuandian.androidstudy.R;
import com.zhuandian.androidstudy.view_activity.view.BannerViewAcitivity;
import com.zhuandian.androidstudy.view_activity.view.banner.BannerItemClickListener;
import com.zhuandian.androidstudy.view_activity.view.banner.BannerView;

public class ViewMainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_main);
        findViewById(R.id.btn_view_drag_helper).setOnClickListener(this);
        findViewById(R.id.btn_banner).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_view_drag_helper:
                startActivity(new Intent(ViewMainActivity.this,ViewDragHelperActivity.class));
                break;
            case R.id.btn_banner:
                startActivity(new Intent(ViewMainActivity.this,BannerViewAcitivity.class));
                break;
        }
    }
}
