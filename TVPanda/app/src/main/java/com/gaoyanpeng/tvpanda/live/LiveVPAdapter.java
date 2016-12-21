package com.gaoyanpeng.tvpanda.live;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Administrator on 2016/12/20.
 * 娱乐界面的ViewPager的适配器
 */
public class LiveVPAdapter extends FragmentStatePagerAdapter {


    public LiveVPAdapter(FragmentManager fm) {
        super(fm);
    }

//    通过getmessage传值到对应的Fragment中返回newInstance方法
//    其中newInstance方法是Fragment中一个静态常量方法
    @Override
    public Fragment getItem(int position) {
        return ReuseFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 0;
    }
}
