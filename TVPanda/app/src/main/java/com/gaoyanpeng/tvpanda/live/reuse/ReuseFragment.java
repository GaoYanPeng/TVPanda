package com.gaoyanpeng.tvpanda.live.reuse;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.widget.LinearLayout;

import com.gaoyanpeng.tvpanda.R;
import com.gaoyanpeng.tvpanda.api.Api;
import com.gaoyanpeng.tvpanda.base.BaseFragment;
import com.gaoyanpeng.tvpanda.live.LiveBean;
import com.gaoyanpeng.tvpanda.live.LiveRVAdapter;
import com.gaoyanpeng.tvpanda.ok.NetTool;
import com.gaoyanpeng.tvpanda.ok.onHttpCallBack;
import com.gaoyanpeng.tvpanda.onclick.RecyclerViewOnClick;

/**
 * Created by Administrator on 2016/12/20.
 * 复用的Fragment
 */
public class ReuseFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private LiveRVAdapter mRvAdapter;
    private String mUrl;

    @Override
    protected int initLayout() {
        return R.layout.fm_reuse;
    }

    @Override
    protected void initView() {
        mRecyclerView = getFindView(R.id.fm_reuse_rv);
        mRvAdapter = new LiveRVAdapter();
    }

    @Override
    protected void initData() {

        Bundle bundle = getArguments();

        if (bundle != null) {
            String cate = bundle.getString("data");
            Log.d("网址", cate);

            mUrl = Api.CATEHead + cate + Api.CATEFoot;
        }

        OkNetMethod();
    }


//    自动生成的方法
    public static ReuseFragment newInstance(int position) {
        Bundle args = new Bundle();
        String data = LiveVPAdapter.getMessage(position);
        Log.d("数据", data);
        args.putString("data",data);
        ReuseFragment fragment = new ReuseFragment();
        fragment.setArguments(args);
        return fragment;
    }

//    OKHTTP网络请求方法
    protected void OkNetMethod () {
        Log.d("网址", mUrl);
        NetTool.getInstance().startRequest(mUrl, LiveBean.class, new onHttpCallBack<LiveBean>() {
            @Override
            public void onSuccess(LiveBean response) {
                Log.d("ReuseFragment", "网络请求成功");
                mRvAdapter.setLiveBeanArrayList(response.getData());
                mRecyclerView.setAdapter(mRvAdapter);
                StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, LinearLayout.VERTICAL);
                mRecyclerView.setLayoutManager(manager);
//    接口回调实现监听
                mRvAdapter.setRecyclerViewOnClick(new RecyclerViewOnClick() {
                    @Override
                    public void onClick(int pos) {

                    }
                });
            }

            @Override
            public void onError(Throwable e) {
                Log.d("ReuseFragment", e.getMessage());
            }
        });
    }

}
