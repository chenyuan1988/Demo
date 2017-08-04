package com.example.chenyuan.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import org.zackratos.ultimatebar.UltimateBar;

/**
 * Created by chenyuan  on 2017/8/4.
 */

public  abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        UltimateBar ultimateBar = new UltimateBar(this);
        //ultimateBar.setColorBar(ContextCompat.getColor(this, R.color.colorPrimary));
        ultimateBar.setImmersionBar();
        initView();
        initData();
        initListener();
    }

    protected abstract int getLayoutId();

    protected abstract void initListener();

    protected abstract void initData();


    protected abstract void initView();

}
