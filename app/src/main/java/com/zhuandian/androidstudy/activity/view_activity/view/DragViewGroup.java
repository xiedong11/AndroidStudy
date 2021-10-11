package com.zhuandian.androidstudy.activity.view_activity.view;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.customview.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * desc :
 * author：xiedong
 * date：2019/5/30
 */
public class DragViewGroup extends FrameLayout {
    private ViewDragHelper viewDragHelper;
    private View menuView, mainView;
    private int width;

    public DragViewGroup(Context context) {
        this(context, null);
    }

    public DragViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DragViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        viewDragHelper = ViewDragHelper.create(this, callback);
    }

    private ViewDragHelper.Callback callback = new ViewDragHelper.Callback() {
        @Override
        public boolean tryCaptureView(@NonNull View view, int i) {
            return true;
        }

        @Override
        public int clampViewPositionHorizontal(@NonNull View child, int left, int dx) {
            return left;
        }

        /**
         *
         * @param child
         * @param top  在垂直方向上移动的距离
         * @param dy   相对于上一次的增量
         * @return
         */
        @Override
        public int clampViewPositionVertical(@NonNull View child, int top, int dy) {
            return top;
        }
    };


    /**
     * 重写onInterceptTouchEvent 、onTouchEvent事件拦截处理，将事件交由 viewDragHelper进行处理
     *
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return viewDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        viewDragHelper.processTouchEvent(event);
        return true;
    }
}
