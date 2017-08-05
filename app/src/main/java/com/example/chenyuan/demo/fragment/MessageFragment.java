package com.example.chenyuan.demo.fragment;

import android.view.View;
import android.widget.TextView;

import com.example.chenyuan.demo.R;

import butterknife.BindView;

/**
 * Created by chenyuan  on 2017/8/5.
 * 消息
 */

public class MessageFragment extends BaseFragment {

    @BindView(R.id.tv)
    TextView mTv;

    @Override
    protected int getLayotId() {
        return R.layout.fragment_message;
    }

    @Override
    protected void initView(View view) {
        for (int i = 0; i < 10000; i++) {
            final int finalI = i;
            mTv.postDelayed(new Runnable() {
                @Override
                public void run() {
                   mTv.setText(finalI+"");
                }
            },1000);

        }

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
