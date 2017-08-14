package com.example.chenyuan.demo.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.example.chenyuan.demo.R;
import com.example.chenyuan.demo.adapter.MyExpendlistviewAdapter;
import com.example.chenyuan.demo.adapter.MyViewFactory;
import com.example.chenyuan.demo.entity.ExpendEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import ezy.ui.view.BannerView;

/**
 * Created by chenyuan  on 2017/8/5.
 * 消息
 */

public class MessageFragment extends BaseFragment {

    @BindView(R.id.elv)
    ExpandableListView mElv;
    Unbinder unbinder;
    private List<String> urls;
    private List<ExpendEntity> data = new ArrayList<>();
    private BannerView mBannerView;
    public static String[] urlss = new String[]{//750x500
            "https://s2.mogucdn.com/mlcdn/c45406/170422_678did070ec6le09de3g15c1l7l36_750x500.jpg",
            "https://s2.mogucdn.com/mlcdn/c45406/170420_1hcbb7h5b58ihilkdec43bd6c2ll6_750x500.jpg",
            "http://s18.mogucdn.com/p2/170122/upload_66g1g3h491bj9kfb6ggd3i1j4c7be_750x500.jpg",
            "http://s18.mogucdn.com/p2/170204/upload_657jk682b5071bi611d9ka6c3j232_750x500.jpg",
            "http://s16.mogucdn.com/p2/170204/upload_56631h6616g4e2e45hc6hf6b7g08f_750x500.jpg",
            "http://s16.mogucdn.com/p2/170206/upload_1759d25k9a3djeb125a5bcg0c43eg_750x500.jpg"
    };

    @Override
    protected int getLayotId() {
        return R.layout.fragment_message;
    }

    @Override
    protected void initView(View view) {
        mBannerView = (BannerView) LayoutInflater.from(getActivity()).inflate(R.layout.banner,null);


    }

    @Override
    protected void initData() {
        urls = Arrays.asList(urlss);

        for (int i = 0; i < 20; i++) {
            ExpendEntity entity = new ExpendEntity();
            entity.setTitle("我们是最棒的" + i);
            List<String> strings = new ArrayList<>();
            Random random = new Random();
            int anInt = random.nextInt(5);
            strings.add(urls.get(anInt));
            int anInt2 = random.nextInt(5);
            strings.add(urls.get(anInt2));
            entity.setUrls(strings);
            data.add(entity);
        }
        mBannerView.setViewFactory(new MyViewFactory());
        mBannerView.setDataList(urls);
        mBannerView.setIsAuto(true);
        mBannerView.start();
        if (mElv.getHeaderViewsCount()==0){
            mElv.addHeaderView(mBannerView);
        }
        MyExpendlistviewAdapter myExpendlistviewAdapter = new MyExpendlistviewAdapter(data, mActivity);
        mElv.setAdapter(myExpendlistviewAdapter);



    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
