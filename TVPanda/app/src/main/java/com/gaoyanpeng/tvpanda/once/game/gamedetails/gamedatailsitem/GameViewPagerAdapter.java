package com.gaoyanpeng.tvpanda.once.game.gamedetails.gamedatailsitem;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gaoyanpeng.tvpanda.R;
import com.gaoyanpeng.tvpanda.once.game.gamedetails.gamedatailsitem.fragment.AnchorFragment;
import com.gaoyanpeng.tvpanda.once.game.gamedetails.gamedatailsitem.fragment.ChatFragment;
import com.gaoyanpeng.tvpanda.once.game.gamedetails.gamedatailsitem.fragment.LevelFragment;

/**
 * Created by 裴亮 on 16/12/28.
 */

public class GameViewPagerAdapter extends FragmentPagerAdapter {

    private GameTabBean bean;
    private Context mContext;
    private ImageView icon;
    private TextView title;

    public GameViewPagerAdapter(FragmentManager fm, Context mContext) {
        super(fm);
        this.mContext = mContext;
    }

    public void setBean(GameTabBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }



    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new ChatFragment();
        }else if (position ==1){
            new LevelFragment();
        }
        return new AnchorFragment() ;
    }

    @Override
    public int getCount() {
        return bean.getTitles().length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return bean.getTitles()[position];
    }

    // 将TabLayout重新进行自定义布局
    public View getTabView(int position) {
        View tabView = LayoutInflater.from(mContext).
                inflate(R.layout.custom_tab_home, null);
        icon = (ImageView) tabView.findViewById(R.id.iv_icon_custom_tab);
        title = (TextView) tabView.findViewById(R.id.tv_title_custom_tab);
        icon.setImageResource(bean.getPics()[position]);
        title.setText(bean.getTitles()[position]);
        return tabView;
    }
}
