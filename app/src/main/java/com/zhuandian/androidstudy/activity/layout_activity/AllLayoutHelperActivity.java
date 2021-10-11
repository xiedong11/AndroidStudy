package com.zhuandian.androidstudy.activity.layout_activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.zhuandian.androidstudy.R;

public class AllLayoutHelperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_layout_helper);


        TextView textView = new TextView(this);
    }
}
