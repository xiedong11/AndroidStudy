package com.zhuandian.androidstudy.notification_activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zhuandian.androidstudy.R;

/**
 * 建造者模式构建通知类： Notification.Builder
 * 通知管理器(用于发出通知)： NotificationManager
 * 通知通道(API 26新增，用户可以选择性屏蔽通知)：NotificationChannel
 * 通知动作(用户点击滑动通知等)：PaddingIntent
 *
 * 发送通知的步骤
 *
 * 获取 NotificationManager
 * 创建 Notification
 * 给 Notification 设置参数
 * 使用 NotificationManager 发送通知
 * Android 7.0 新内容
 *
 * Notification.Builder.serPriority: 设置通知优先级 Notification.Builder.setStyle: 设置通知扩展布局 MessagingStyle: 快速回复
 *
 * Android 8.0 新内容
 *
 * NotificationChannel：用户可以自定义通知的显示，以及关闭某个通知的提示音震动等
 */
public class NotificationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
//        https://www.liangzl.com/get-article-detail-18070.html
    }
}
