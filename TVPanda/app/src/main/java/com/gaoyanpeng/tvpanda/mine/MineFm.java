package com.gaoyanpeng.tvpanda.mine;


import android.view.View;

import com.gaoyanpeng.tvpanda.R;
import com.gaoyanpeng.tvpanda.base.BaseFragment;
import com.gaoyanpeng.tvpanda.view.PullToZoomScrollViewEx;

/**
 * 我的
 * Created by 高研鹏 on 2016/12/17.
 */

public class MineFm extends BaseFragment {
    private PullToZoomScrollViewEx scrollView;

    @Override
    protected int initLayout() {
        return R.layout.fm_mine;
    }

    @Override
    protected void initView() {
        scrollView = getFindView(R.id.scrollView);
        //设置头布局
        View headerview = View.inflate(getContext(), R.layout.widget_profile_headview, null);
        //设置缩放视图
        View zoomview = View.inflate(getContext(), R.layout.widget_zoomview, null);
        //设置滚动试图内容
        View contentview = View.inflate(getContext(), R.layout.widget_profile_contentview, null);
        //设置头布局
        scrollView.setHeaderView(headerview);
        //设置缩放视图
        scrollView.setZoomView(zoomview);
        //设置滚动试图内容
        scrollView.setScrollContentView(contentview);

    }

    @Override
    protected void initData() {

    }
}
