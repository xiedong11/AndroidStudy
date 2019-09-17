package com.zhuandian.androidstudy.activity.handler_test;

import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zhuandian.androidstudy.R;

public class HandleTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle_test);
    }



    class LooperThread extends Thread{
        @Override
        public void run() {
            Looper.prepare();


            Looper.loop();
        }
    }
}
