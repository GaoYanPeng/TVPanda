package com.gaoyanpeng.tvpanda.live;

import android.support.v7.widget.RecyclerView;

import com.gaoyanpeng.tvpanda.R;
import com.gaoyanpeng.tvpanda.base.BaseFragment;

/**
 * Created by Administrator on 2016/12/20.
 * 复用的Fragment
 */
public class ReuseFragment extends BaseFragment {

    private RecyclerView mRecyclerView;

    @Override
    protected int initLayout() {
        return R.layout.fm_reuse;
    }

    @Override
    protected void initView() {
        mRecyclerView = getFindView(R.id.fm_reuse_rv);

    }

    @Override
    protected void initData() {

    }
}
