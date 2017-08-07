package com.example.chenyuan.demo.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * Created by chenyuan  on 2017/8/4.
 */

public abstract class BaseActivity extends AppCompatActivity {
    public static Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        context = this;
       /* UltimateBar ultimateBar = new UltimateBar(this);
        //ultimateBar.setColorBar(ContextCompat.getColor(this, R.color.colorPrimary));
        ultimateBar.setImmersionBar();*/
        initView();
        initData();
        initListener();
    }

    protected abstract int getLayoutId();

    protected abstract void initListener();

    protected abstract void initData();


    protected abstract void initView();

    public void creationAction(Class aClass, Bundle bundle) {
        Intent intent = new Intent(context, aClass);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        context.startActivity(intent);

    }

    public static void creationAction(Class aClass) {
        Intent intent = new Intent(context, aClass);
        context.startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
