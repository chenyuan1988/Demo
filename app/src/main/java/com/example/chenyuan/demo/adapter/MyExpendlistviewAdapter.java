package com.example.chenyuan.demo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.chenyuan.demo.R;
import com.example.chenyuan.demo.entity.ExpendEntity;
import com.example.chenyuan.demo.view.ScrollGridLayoutManager;

import java.util.List;

/**
 * Created by chenyuan  on 2017/8/14.
 */

public class MyExpendlistviewAdapter extends BaseExpandableListAdapter {
    private List<ExpendEntity> data;
    private Context mContext;


    public MyExpendlistviewAdapter(List<ExpendEntity> data, Context context) {
        this.data = data;
        mContext = context;
    }

    @Override
    public int getGroupCount() {
        return data.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        TextView tv = (TextView) LayoutInflater.from(mContext).inflate(R.layout.father, null);
        ExpendEntity entity = data.get(groupPosition);
        tv.setText(entity.getTitle());
        return tv;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        RecyclerView view = (RecyclerView) LayoutInflater.from(mContext).inflate(R.layout.child, null);
        ScrollGridLayoutManager manager = new ScrollGridLayoutManager(mContext, 2) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        view.setLayoutManager(manager);
        MyRecycleViewAdapter myRecycleViewAdapter = new MyRecycleViewAdapter(mContext, data.get(groupPosition).getUrls());
        view.setAdapter(myRecycleViewAdapter);
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
