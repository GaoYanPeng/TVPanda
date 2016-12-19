package com.gaoyanpeng.tvpanda.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**Main的适配器
 * Created by 高研鹏 on 2016/12/17.
 */

public class MainAdapter extends FragmentPagerAdapter {

    public MainAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return MainBean.getMainBean().get(position).getF();
    }

    @Override
    public int getCount() {
        return MainBean.getMainBean().size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return MainBean.getMainBean().get(position).getTitle();

    }
}
