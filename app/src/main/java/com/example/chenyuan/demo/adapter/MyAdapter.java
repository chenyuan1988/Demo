package com.example.chenyuan.demo.adapter;

import android.content.Context;

import com.example.chenyuan.demo.R;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;

import java.util.List;

/**
 * Created by chenyuan  on 2017/7/27.
 */

public class MyAdapter extends CommonAdapter<String> {
    public MyAdapter(Context context, List<String> datas) {
        super(context,R.layout.item_mainacitity, datas);
    }

    @Override
    protected void convert(ViewHolder viewHolder, String s, int i) {
        viewHolder.setText(R.id.tv, s);
    }
}
