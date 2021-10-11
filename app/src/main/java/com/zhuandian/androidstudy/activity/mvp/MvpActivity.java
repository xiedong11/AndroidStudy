package com.zhuandian.androidstudy.activity.mvp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.zhuandian.androidstudy.R;

public class MvpActivity extends AppCompatActivity implements IDemoView<Entity> {

    private DemoPresenter demoPresenter = new DemoPresenter(this);
    private TextView tvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        tvMsg = (TextView) findViewById(R.id.tv_msg);

        demoPresenter.onReqestData();
    }

    @Override
    public void updateUI(Entity entity) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvMsg.setText(entity.getMsg());
            }
        });

    }
}
