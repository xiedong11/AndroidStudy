package com.zhuandian.androidstudy.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import com.zhuandian.androidstudy.R;
import com.zhuandian.androidstudy.base.aop.ClassTest;
import com.zhuandian.androidstudy.base.aop.MethodsTest;

@ClassTest(type = ClassTest.TYPE_2)
public class AopTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aop_test);

        test(3);
    }

    @MethodsTest(type = 1)
    private void test(int i) {
    }
}
