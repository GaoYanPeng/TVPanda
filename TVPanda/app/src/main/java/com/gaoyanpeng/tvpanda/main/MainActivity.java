package com.gaoyanpeng.tvpanda.main;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gaoyanpeng.tvpanda.R;
import com.gaoyanpeng.tvpanda.base.BaseActivity;
import com.gaoyanpeng.tvpanda.seek.SeekAty;
import com.gaoyanpeng.tvpanda.set.SettingAty;


public class MainActivity extends BaseActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private MainAdapter mMainAdapter;
    private TextView mTitle;
    private ImageView mTitlePic, mRightPic, mRightSetting;
    //定义当前的时间
    private long firstTime = 0;
    private TabLayout.Tab mTab;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        mTabLayout = findView(R.id.main_tab);
        mViewPager = findView(R.id.main_vp);
        mMainAdapter = new MainAdapter(getSupportFragmentManager());
        mTitle = findView(R.id.main_title);
        mTitlePic = findView(R.id.main_title_pic);
        mRightPic = findView(R.id.main_right_pic);
        mRightSetting = findView(R.id.main_right_setting);

    }

    @Override
    protected void initThis() {
        mRightPic.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        mViewPager.setAdapter(mMainAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        //设置 TabLayout
        getTabLayout();
        /**
         * 监听ViewPager当前是第几页
         */
        mViewPager.addOnPageChangeListener(this);

    }

    private void getTabLayout() {
        //设置下划线颜色
        mTabLayout.setSelectedTabIndicatorColor(0x00000000);
        //设置字体点击与不点击的颜色
        mTabLayout.setTabTextColors(Color.rgb(0x81, 0x81, 0x81), Color.rgb(0x2E, 0xD2, 0x9C));
        // TODO: 2016/12/17 显示图片 使用tablayout + viewpager时注意 图片和文子分开是时候
        // TODO: 2016/12/17如果设置了setupWithViewPager 则需要重新执行下方对每个条目赋值
        // TODO: 2016/12/17否则会出现icon文字不显示的bug
        int tabCont = mTabLayout.getTabCount();
        for (int i = 0; i < tabCont; i++) {
            mTab = mTabLayout.getTabAt(i);
            mTab.setIcon(MainBean.getMainBean().get(i).getImage());
        }
    }

    //点击两次退出程序
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                long secondTime = System.currentTimeMillis();
                if (secondTime - firstTime > 2000) {
                    Toast.makeText(this, "再点击一次退出程序", Toast.LENGTH_SHORT).show();
                    firstTime = secondTime;//更新firstTime
                    return true;
                } else {
                    System.exit(0);
                }
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    /**
     * 监听ViewPager当前是第几页
     */
    @Override
    public void onPageSelected(int position) {
        Log.d("MainActivity", "position:" + position);
        if (position == 0) {
            mRightPic.setVisibility(View.VISIBLE);
            mRightSetting.setVisibility(View.GONE);
            mTitlePic.setVisibility(View.VISIBLE);
            mTitle.setVisibility(View.GONE);
        } else if (position == 1) {
            mRightPic.setVisibility(View.VISIBLE);
            mRightSetting.setVisibility(View.GONE);
            mTitlePic.setVisibility(View.GONE);
            mTitle.setVisibility(View.VISIBLE);
            mTitle.setText("游戏");
        } else if (position == 2) {
            mRightPic.setVisibility(View.VISIBLE);
            mRightSetting.setVisibility(View.GONE);
            mTitlePic.setVisibility(View.GONE);
            mTitle.setVisibility(View.VISIBLE);
            mTitle.setText("娱乐");
        } else if (position == 3) {
            mRightPic.setVisibility(View.VISIBLE);
            mRightSetting.setVisibility(View.GONE);
            mTitlePic.setVisibility(View.GONE);
            mTitle.setVisibility(View.VISIBLE);
            mTitle.setText("小葱秀");
        } else if (position == 4) {
            mTitlePic.setVisibility(View.GONE);
            mTitle.setVisibility(View.VISIBLE);
            mRightPic.setVisibility(View.GONE);
            mRightSetting.setVisibility(View.VISIBLE);
            mTitle.setText("我的");
            mRightSetting.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, SettingAty.class);
                    startActivity(intent);
                }
            });
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent(this, SeekAty.class);
        startActivity(intent);
    }
}
