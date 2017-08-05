package com.example.chenyuan.demo.fragment;

/**
 * Created by chenyuan  on 2017/8/5.
 */

public class FragmentFactory {
    private static MessageFragment sMessageFragment = null;
    private static ContentPersonFragment sContentPersonFragment = null;
    private static DynicFragment sDynicFragment = null;

    public static BaseFragment getInstance(int position) {
        BaseFragment fragment = null;
        switch (position) {
            case 0:
                if (sMessageFragment == null) {
                    sMessageFragment = new MessageFragment();
                }
                fragment = sMessageFragment;
                break;
            case 1:
                if (sContentPersonFragment == null) {
                    sContentPersonFragment = new ContentPersonFragment();
                }
                fragment = sContentPersonFragment;
                break;
            case 2:
                if (sDynicFragment == null) {
                    sDynicFragment = new DynicFragment();
                }
                fragment = sDynicFragment;
                break;


        }
        return fragment;
    }

}
