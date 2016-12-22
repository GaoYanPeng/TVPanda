package com.gaoyanpeng.tvpanda.live;


import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.gaoyanpeng.tvpanda.R;
import com.gaoyanpeng.tvpanda.base.BaseFragment;
import com.gaoyanpeng.tvpanda.ok.NetTool;
import com.gaoyanpeng.tvpanda.ok.onHttpCallBack;

import okhttp3.OkHttpClient;

/**娱乐赵宁来做 记住只能在自己的包下面做 别的包只能看不要改动
 * Created by 高研鹏 on 2016/12/17.
 */

public class LiveFm extends BaseFragment {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private LiveVPAdapter mLiveVPAdapter;

    @Override
    protected int initLayout() {
        return R.layout.fm_live;
    }

    @Override
    protected void initView() {
        mViewPager = getFindView(R.id.live_vp);
        mTabLayout = getFindView(R.id.live_tab);

        mLiveVPAdapter = new LiveVPAdapter(getChildFragmentManager());
        mViewPager.setAdapter(mLiveVPAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.setTabTextColors(Color.rgb(0x81, 0x81, 0x81), Color.rgb(0x2E, 0xD2, 0x9C));
        mTabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorGrayLine));

    }

    @Override
    protected void initData() {
        OkNetMethod();
    }

//    网络请求方法
    protected void OkNetMethod() {
        NetTool.getInstance().startRequest(URLLive.LIIVEURL, LiveBean.class, new onHttpCallBack<LiveBean>() {
            @Override
            public void onSuccess(LiveBean response) {
                Log.d("LiveFm", "网络请求成功");
                Log.d("LiveFm", response.getData().getItems().get(0).getEnd_time());
//                获取viewpager里面的标题
                mLiveVPAdapter.setmBean(response);
                mViewPager.setAdapter(mLiveVPAdapter);
                mTabLayout.setupWithViewPager(mViewPager);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("LiveFm", e.getMessage());
            }
        });
    }

}
