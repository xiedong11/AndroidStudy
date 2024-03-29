package com.zhuandian.androidstudy.activity.layout_activity;

import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.alibaba.android.vlayout.layout.StickyLayoutHelper;
import com.zhuandian.androidstudy.R;
import com.zhuandian.androidstudy.adapter.CommonAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 布局说明：布局只有一个Item，显示逻辑如下：
 * 当它包含的组件处于屏幕可见范围内时，像正常的组件一样随页面滚动而滚动
 * 当组件将要被滑出屏幕返回的时候，可以吸到屏幕的顶部或者底部，实现一种吸住的效果
 *
 *
 */
public class StickLayoutActivity extends AppCompatActivity {

    private RecyclerView rvList;
    private DelegateAdapter delegateAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stick_layout);

        rvList = (RecyclerView) findViewById(R.id.rv_list);
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(this);
        rvList.setLayoutManager(virtualLayoutManager);
        delegateAdapter = new DelegateAdapter(virtualLayoutManager, true);
        rvList.setAdapter(delegateAdapter);


        initLinearLayout();
        initStickLayout();
        initLinearLayout();


    }

    private void initStickLayout() {
        /**
         设置吸边布局
         */
        StickyLayoutHelper stickyLayoutHelper = new StickyLayoutHelper();
        // 公共属性
        stickyLayoutHelper.setItemCount(3);// 设置布局里Item个数
        stickyLayoutHelper.setPadding(20, 20, 20, 20);// 设置LayoutHelper的子元素相对LayoutHelper边缘的距离
        stickyLayoutHelper.setMargin(20, 20, 20, 20);// 设置LayoutHelper边缘相对父控件（即RecyclerView）的距离
        stickyLayoutHelper.setBgColor(Color.GRAY);// 设置背景颜色
        stickyLayoutHelper.setAspectRatio(3);// 设置设置布局内每行布局的宽与高的比

        // 特有属性
        stickyLayoutHelper.setStickyStart(true);        // true = 组件吸在顶部
        // false = 组件吸在底部

        stickyLayoutHelper.setOffset(100);// 设置吸边位置的偏移量

        List<String> datas = new ArrayList<>();
//        for (int i = 0; i < 15; i++) {
//            datas.add("吸顶布局");
//        }
        datas.add("吸顶布局");

        delegateAdapter.addAdapter(new CommonAdapter(stickyLayoutHelper, this, datas));        // 将当前的Adapter加入到Adapter列表里

    }

    private void initLinearLayout() {

        //Linear 布局
        LinearLayoutHelper linearHelper = new LinearLayoutHelper(10, 12);   //构造方法中可以直接指定dividerHeight,itemCount,也可以单独使用
        linearHelper.setItemCount(12); //具体数目以adapter中的数据集合数据为准
        linearHelper.setPadding(0, 10, 10, 10);
        linearHelper.setMargin(0, 10, 10, 10);
        linearHelper.setBgColor(Color.GRAY);// 设置背景颜色
        linearHelper.setAspectRatio(6);// 设置设置布局内每行布局的宽与高的比

        // linearLayoutHelper特有属性
        linearHelper.setDividerHeight(10); // 设置每行Item的距离


        List<String> datas = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            datas.add("Item  " + i);
        }
        delegateAdapter.addAdapter(new CommonAdapter(linearHelper, this, datas));
    }

}
