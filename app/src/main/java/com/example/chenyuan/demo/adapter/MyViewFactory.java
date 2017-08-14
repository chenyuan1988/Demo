package com.example.chenyuan.demo.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import ezy.ui.view.BannerView;

/**
 * Created by chenyuan  on 2017/8/14.
 */

public class MyViewFactory implements BannerView.ViewFactory<String> {

    @Override
    public View create(String s, int i, ViewGroup viewGroup) {
        ImageView iv = new ImageView(viewGroup.getContext());
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        RequestOptions options = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.DATA);
        Glide.with(viewGroup.getContext().getApplicationContext()).load(s).apply(options).into(iv);
        return iv;
    }
}
