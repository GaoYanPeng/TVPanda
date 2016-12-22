package com.gaoyanpeng.tvpanda.live.reuse;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.gaoyanpeng.tvpanda.live.LiveBean;

/**
 * Created by Administrator on 2016/12/20.
 * 娱乐界面的ViewPager的适配器
 */
public class LiveVPAdapter extends FragmentStatePagerAdapter {

    private static String [] Content = {"yzdr","hwzb","music","pets","boardgames","cartoon","sport","technology","finance"};
    private static String [] title = {"熊猫星秀","户外直播","音乐","萌宠乐园","桌游","影评专区","体坛风云","科技前沿","金融理财"};

    private static LiveBean mBean;

    public LiveVPAdapter(FragmentManager fm) {
        super(fm);
    }

    public  void setmBean(LiveBean mBean) {
        LiveVPAdapter.mBean = mBean;
        notifyDataSetChanged();
    }

//    通过getmessage传值到对应的Fragment中返回newInstance方法
//    其中newInstance方法是Fragment中一个静态常量方法
    @Override
    public Fragment getItem(int position) {
        return mBean!= null  &&mBean.getData().getItems().size() > 0 ?  ReuseFragment.newInstance(position) : null;
    }

//    获取对应的返回页数
    @Override
    public int getCount() {
        return mBean == null ? 0 : title.length;
    }

//    获取对应的标题
    @Override
    public CharSequence getPageTitle(int position) {
        return  title[position] ;
    }

//    获取字符串里面不同的total
    public static String getMessage (int pos) {
        return Content[pos];

    }

}
