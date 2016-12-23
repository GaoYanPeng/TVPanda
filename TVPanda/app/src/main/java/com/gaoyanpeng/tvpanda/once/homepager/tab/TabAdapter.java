package com.gaoyanpeng.tvpanda.once.homepager.tab;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gaoyanpeng.tvpanda.R;
import com.gaoyanpeng.tvpanda.once.homepager.commonfragment.CommonFragment;
import com.gaoyanpeng.tvpanda.once.homepager.livefragment.LiveFragment;
import com.gaoyanpeng.tvpanda.once.homepager.recommendfragment.RecommendFragment;


/**
 * Created by 裴亮 on 16/12/21.
 */

public class TabAdapter extends FragmentStatePagerAdapter {

    private static TabBean tabBean; // 实体类
    private ImageView icon; // tab 图标
    private TextView title; // tab 标题
    private Context mContext;

    public TabAdapter(FragmentManager fm, Context mContext) {
        super(fm);
        this.mContext = mContext;
    }

    public void setTabBean(TabBean tabBean) {
        this.tabBean = tabBean;
        notifyDataSetChanged();
    }

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // 根据位置进行判断是哪个fragment
        if (position == 0) {
            return new RecommendFragment();
        } else if (position == 1) {
            return new LiveFragment();
        }
        return CommonFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return tabBean == null ? 0 : tabBean.getTitles().length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // 返回TabLayout 标题
        return tabBean.getTitles()[position];
    }

    // 对外提供一个静态的方法来获取复用网址拼接的字段
    public static String getData(int position) {
        return tabBean.getEnames()[position];
    }

    // 将TabLayout重新进行自定义布局
    public View getTabView(int position) {
        View tabView = LayoutInflater.from(mContext).
                inflate(R.layout.custom_tab_home, null);
        icon = (ImageView) tabView.findViewById(R.id.iv_icon_custom_tab);
        title = (TextView) tabView.findViewById(R.id.tv_title_custom_tab);
        icon.setImageResource(tabBean.getPics()[position]);
        title.setText(tabBean.getTitles()[position]);
        return tabView;
    }
}
