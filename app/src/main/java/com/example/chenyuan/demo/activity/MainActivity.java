package com.example.chenyuan.demo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.chenyuan.demo.R;
import com.example.chenyuan.demo.adapter.MyAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SmartRefreshLayout smartreflesh;
    private RecyclerView rcv;
    private List<String> data = new ArrayList<>();
    private MyAdapter mMyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initListener();
    }
    private void initData() {

        mMyAdapter = new MyAdapter(this, data);
        rcv.setAdapter(mMyAdapter);
    }

    private void initListener() {
        smartreflesh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshLayout) {
                data.clear();
                smartreflesh.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 3; i++) {
                            data.add("陈原" + i);
                        }
                        smartreflesh.finishRefresh();
                        mMyAdapter.notifyDataSetChanged();

                    }
                },2000);


            }
        });
        smartreflesh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshLayout) {
                smartreflesh.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        List list = new ArrayList();
                        for (int i = 0; i < 3; i++) {
                            list.add("陈原" + i);
                        }
                        data.addAll(list);
                        smartreflesh.finishLoadmore();
                        mMyAdapter.notifyDataSetChanged();

                    }
                },2000);

            }
        });
    }
    private void initView() {
        smartreflesh = (SmartRefreshLayout) findViewById(R.id.smartreflesh);
        rcv = (RecyclerView) findViewById(R.id.rcv);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        rcv.setLayoutManager(manager);
        smartreflesh.autoRefresh();
    }
}