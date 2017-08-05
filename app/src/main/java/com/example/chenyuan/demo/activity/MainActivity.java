package com.example.chenyuan.demo.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.chenyuan.demo.R;
import com.example.chenyuan.demo.fragment.BaseFragment;
import com.example.chenyuan.demo.fragment.FragmentFactory;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {

    @BindView(R.id.fl_content)
    FrameLayout mFlContent;
    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar mBottomNavigationBar;
    @BindView(R.id.tv_title)
    TextView mTvTitle;
    @BindView(R.id.tb_toolbar)
    Toolbar mTbToolbar;
    private List<String> mStrings;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    protected void initData() {
        mStrings = Arrays.asList(getResources().getStringArray(R.array.titlelist));
        mBottomNavigationBar.selectTab(0);
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (fragments != null && fragments.size() > 0) {
            for (int i = 0; i < fragments.size(); i++) {
                transaction.remove(fragments.get(i));
            }
            transaction.commit();
        }
        BaseFragment fragment = FragmentFactory.getInstance(0);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fl_content, fragment, "0");
        mTvTitle.setText(mStrings.get(0));

    }

    protected void initListener() {


    }

    protected void initView() {
        BottomNavigationItem conversationItem = new BottomNavigationItem(R.mipmap.first_presed, "消息");
        //BadgeItem 底部导航图标 右上角的圆圈文字
        conversationItem.setInactiveIconResource(R.mipmap.first);
        mBottomNavigationBar.addItem(conversationItem);

        BottomNavigationItem item = new BottomNavigationItem(R.mipmap.second_presed, "联系人");
        item.setInactiveIconResource(R.mipmap.second);

//        item.setInActiveColor(getResources().getColor(R.color.inactive));
        mBottomNavigationBar.addItem(item);
        BottomNavigationItem item2 = new BottomNavigationItem(R.mipmap.qg, "动态");
//        item.setActiveColor(getResources().getColor(R.color.btn_normal));
//        item.setInActiveColor(getResources().getColor(R.color.inactive));
        item2.setInactiveIconResource(R.mipmap.qg_presed);
        mBottomNavigationBar.addItem(item2);

        //设置选中时的颜色
        mBottomNavigationBar.setActiveColor(R.color.btn_normal);
        // 设置没被选中时的颜色
        mBottomNavigationBar.setInActiveColor(R.color.inactive);

        //可以修改第一次加载时被选中的tab的 位置
        //  BottomNavigationBar.setFirstSelectedPosition(1);
        //初始化
        mBottomNavigationBar.initialise();

        mBottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                //被选中了
                Log.e("Mainactivity", "onTabSelected" + position);
                //通过postion拿到fragment
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                BaseFragment fragment = FragmentFactory.getInstance(position);
                if (fragment.isAdded()) {
                    //如果这个fragment 已经被add进来 显示一下
                    transaction.show(fragment).commit();
                } else {
                    // 如果这个fragment 没有被add进来 那么把fragmentadd到主界面中
                    transaction.add(R.id.fl_content, fragment, position + "").commit();
                }
                mTvTitle.setText(mStrings.get(position));
            }

            @Override
            public void onTabUnselected(int position) {
                Log.e("Mainactivity", "onTabUnselected" + position);
                //没被选中
                //通过position找到fragment隐藏起来
                getSupportFragmentManager().beginTransaction().hide(FragmentFactory.getInstance(position)).commit();
            }

            @Override
            public void onTabReselected(int position) {
            }
        });


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
       /* for (int i = 0; i < 3; i++) {
            BaseFragment instance = FragmentFactory.getInstance(i);
            instance = null;
        }*/
    }
}
