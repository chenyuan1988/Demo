package com.example.chenyuan.demo.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.chenyuan.demo.R;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by chenyuan  on 2017/8/14.
 */

public class MyRecycleViewAdapter extends CommonAdapter<String> {
    private Context mContext;

    public MyRecycleViewAdapter(Context context, List<String> datas) {
        super(context, R.layout.item_imageview, datas);
        this.mContext = context;
    }

    @Override
    protected void convert(ViewHolder viewHolder, String s, int i) {
        ImageView iv = viewHolder.getView(R.id.iv);
        Glide.with(mContext).load(s).into(iv);
    }
}
