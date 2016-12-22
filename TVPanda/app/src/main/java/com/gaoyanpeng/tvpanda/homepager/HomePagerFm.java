package com.gaoyanpeng.tvpanda.homepager;


import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.gaoyanpeng.tvpanda.R;
import com.gaoyanpeng.tvpanda.base.BaseFragment;
import com.gaoyanpeng.tvpanda.homepager.tab.TabAdapter;
import com.gaoyanpeng.tvpanda.homepager.tab.TabBean;

/**
 * 首页裴亮来做 记住只能在自己的包下面做 别的包只能看不要改动
 * Created by 高研鹏 on 2016/12/17.
 */

public class HomePagerFm extends BaseFragment {

    private TabBean bean; // TabLayout 上方的实体类
    private TabLayout tab;
    private ViewPager vp;
    private TabLayout.Tab mTab;

    @Override
    protected int initLayout() {
        return R.layout.fm_home_pager;
    }

    @Override
    protected void initView() {
        initViews();
    }

    private void initViews() {
        tab = getFindView(R.id.tab_home);
        vp = getFindView(R.id.vp_home);
        // 初始化实体类
        bean = new TabBean();
        // 初始化ViewPager Adapter
        TabAdapter adapter = new TabAdapter(getChildFragmentManager(), mContext);
        adapter.setTabBean(bean);
        vp.setAdapter(adapter);
        // 将vp与tab进行绑定
        tab.setupWithViewPager(vp);
        // 设置tab滚动方式
        tab.setTabMode(TabLayout.MODE_SCROLLABLE);
        tab.setSelectedTabIndicatorColor(Color.rgb(0x2E, 0xD2, 0x9C));

        // 获取tab的数量
        int tabCount = tab.getTabCount();
        for (int i = 0; i < tabCount; i++) {
            // 获取具体的tab
            mTab = tab.getTabAt(i);
            // 给具体tab设置成自定义的tabView
            mTab.setCustomView(adapter.getTabView(i));
        }
    }

    @Override
    protected void initData() {

    }
}
