package com.zhuandian.androidstudy.view_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.zhuandian.androidstudy.R;
import com.zhuandian.androidstudy.view_activity.view.banner.BannerItemClickListener;
import com.zhuandian.androidstudy.view_activity.view.banner.BannerView;

public class ViewMainActivity extends AppCompatActivity implements BannerItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_main);
        ((BannerView) findViewById(R.id.banner)).setItemClickListener(this);
    }

    @Override
    public void onItemClick(int postion) {
        Toast.makeText(this, "--"+postion, Toast.LENGTH_SHORT).show();
    }
}
