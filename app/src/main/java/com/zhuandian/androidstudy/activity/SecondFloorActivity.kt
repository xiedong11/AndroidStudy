package com.zhuandian.androidstudy.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.scwang.smartrefresh.layout.api.OnTwoLevelListener
import com.scwang.smartrefresh.layout.api.RefreshHeader
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.constant.RefreshState
import com.scwang.smartrefresh.layout.listener.SimpleMultiPurposeListener
import com.zhuandian.androidstudy.R
import kotlinx.android.synthetic.main.activity_second_floor.*

class SecondFloorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_floor)


        refreshLayout.setOnMultiPurposeListener(object : SimpleMultiPurposeListener() {
            override fun onLoadMore(refreshLayout: RefreshLayout) {
                refreshLayout.finishLoadMore(2000)
            }

            override fun onRefresh(refreshLayout: RefreshLayout) {
                Toast.makeText(this@SecondFloorActivity, "触发刷新事件", Toast.LENGTH_SHORT).show()
                refreshLayout.finishRefresh(2000)
            }

            override fun onHeaderMoving(header: RefreshHeader, isDragging: Boolean, percent: Float, offset: Int, headerHeight: Int, maxDragHeight: Int) {
                toolbar.setAlpha(1 - Math.min(percent, 1f))
                iv_second_floor_bg.setTranslationY(Math.min(offset - iv_second_floor_bg.getHeight() + toolbar.getHeight(), refreshLayout.getLayout().getHeight() - iv_second_floor_bg.getHeight()).toFloat())
            }

            override fun onStateChanged(refreshLayout: RefreshLayout, oldState: RefreshState, newState: RefreshState) {
                if (oldState == RefreshState.TwoLevel) {
                    fl_second_floor_content.animate().alpha(0f).setDuration(1000)
                }
            }
        })

        secondFloorHeader.setOnTwoLevelListener {
            Toast.makeText(this@SecondFloorActivity, "触发二楼事件", Toast.LENGTH_SHORT).show()

            //1.直接在二楼显示内容
            fl_second_floor_content.animate().alpha(1f).setDuration(2000)

            refreshLayout.layout.postDelayed(object : Runnable {
                override fun run() {
                    secondFloorHeader.finishTwoLevel()
                    //关闭二楼，进入新页面显示内容。
                }
            }, 5000)
            true //true 将会展开二楼状态 false 关闭刷新
        }

        refreshLayout.setOnRefreshListener { refreshLayout ->
            Toast.makeText(this@SecondFloorActivity, "触发刷新事件", Toast.LENGTH_SHORT).show()
            refreshLayout.finishRefresh(2000)
        }
    }
}
