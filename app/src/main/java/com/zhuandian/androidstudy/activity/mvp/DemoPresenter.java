package com.zhuandian.androidstudy.activity.mvp;

/**
 * desc :
 * author：xiedong
 * date：2019/8/14
 */
public class DemoPresenter {
    private IDemoView mView;
    private DemoModel mModel;

    public DemoPresenter(IDemoView view) {
        mView = view;
        mModel = new DemoModel();
    }


    public void onReqestData() {
        mModel.onRequestData(new CallBack<Entity>() {
            @Override
            public void onSuccess(Entity entity) {
                mView.updateUI(entity);
            }
        });
    }
}
