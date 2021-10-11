package com.zhuandian.androidstudy.activity.darg_list;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhuandian.androidstudy.R;

import java.util.List;

/**
 * @author xiedong
 * @desc
 * @date 2020-03-16.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {


    private List<ItemEntity> list;

    public RecyclerViewAdapter(List<ItemEntity> list) {
        this.list = list;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ItemEntity msg = list.get(position);
        holder.tv_username.setText(msg.getUsername());
        holder.tv_time.setText(msg.getTime());
        holder.tv_message.setText(msg.getMessage());
        holder.iv_icon.setBackgroundResource(msg.getImg_id());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tv_username, tv_time, tv_message;
        private ImageView iv_icon;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_username = (TextView) itemView.findViewById(R.id.tv_username);
            tv_time = (TextView) itemView.findViewById(R.id.tv_time);
            tv_message = (TextView) itemView.findViewById(R.id.tv_message);
            iv_icon = (ImageView) itemView.findViewById(R.id.iv_icon);
        }
    }

}
