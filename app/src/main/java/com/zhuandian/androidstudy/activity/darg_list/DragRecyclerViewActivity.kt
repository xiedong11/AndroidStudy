package com.zhuandian.androidstudy.activity.darg_list

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import com.zhuandian.androidstudy.R
import kotlinx.android.synthetic.main.activity_drag_recycler_view.*
import java.util.*


class DragRecyclerViewActivity : AppCompatActivity() {

    lateinit var adapter:RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drag_recycler_view)

        var list = arrayListOf<ItemEntity>()
        for (i in 1..10) {
            list.add(ItemEntity("title" + i, "2020-02-25", "lsdfakljklsadjklfjdklsaf--" + i))
        }
        adapter = RecyclerViewAdapter(list)

        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this)


        //为RecycleView绑定触摸事件
        //为RecycleView绑定触摸事件
        val helper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
            override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int { //首先回调的方法 返回int表示是否监听该方向
                val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN //拖拽
                val swipeFlags = ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT //侧滑删除
                return makeMovementFlags(dragFlags, swipeFlags)
            }

            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean { //滑动事件
                Collections.swap(list, viewHolder.adapterPosition, target.adapterPosition)
                adapter.notifyItemMoved(viewHolder.adapterPosition, target.adapterPosition)
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) { //侧滑事件
                list.removeAt(viewHolder.adapterPosition)
                adapter.notifyItemRemoved(viewHolder.adapterPosition)
            }

            override fun isLongPressDragEnabled(): Boolean { //是否可拖拽
                return true
            }
        })
        helper.attachToRecyclerView(recyclerview)


    }
}
