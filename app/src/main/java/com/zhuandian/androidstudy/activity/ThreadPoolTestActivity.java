package com.zhuandian.androidstudy.activity;

import android.annotation.SuppressLint;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.zhuandian.androidstudy.R;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTestActivity extends AppCompatActivity {

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_pool_test);
        WebView webView = findViewById(R.id.wv_page);
        webView.addJavascriptInterface(this,"android");//添加js监听 这样html就能调用客户端
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());

        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);//允许使用js
        webView.loadUrl("https://blog.csdn.net/xieluoxixi/article/details/102579088");

        cachedThreadPoolTest();
    }

    private void cachedThreadPoolTest() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();

        cachedThreadPool.execute(t1);
        cachedThreadPool.execute(t2);
        cachedThreadPool.execute(t3);
        cachedThreadPool.execute(t4);
        cachedThreadPool.execute(t5);

        cachedThreadPool.shutdown();

    }


    class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("正在执行----" + Thread.currentThread().getName());
        }
    }
}
