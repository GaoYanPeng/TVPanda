package com.gaoyanpeng.tvpanda.once.homepager.livefragment;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;

import com.gaoyanpeng.tvpanda.R;
import com.gaoyanpeng.tvpanda.api.Api;
import com.gaoyanpeng.tvpanda.base.BaseFragment;
import com.gaoyanpeng.tvpanda.ok.NetTool;
import com.gaoyanpeng.tvpanda.ok.onHttpCallBack;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;

/**
 * Created by 裴亮 on 16/12/22.
 */
public class LiveFragment extends BaseFragment {

    private LiveAdapter adapter;
    private int i = 1;// 初始页为第一页
    private LRecyclerView rv;
    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private String newUrl; // 加载拼接网址
    @Override
    protected int initLayout() {
        return R.layout.fragment_common_home;
    }

    @Override
    protected void initView() {
        initViews();
        refreshAndLoadMoreListener();
    }

    private void initViews() {
        rv =  getFindView(R.id.rv_common);
        adapter = new LiveAdapter();
        lRecyclerViewAdapter = new LRecyclerViewAdapter(adapter);
        rv.setAdapter(lRecyclerViewAdapter);
        rv.setLayoutManager(new StaggeredGridLayoutManager(2,1));

    }

    private void refreshAndLoadMoreListener() {
        rv.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                rv.refreshComplete();
                lRecyclerViewAdapter.notifyDataSetChanged();
            }
        });
        rv.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                newUrl = Api.ALL_LIVE_HEAD_URL + (i + 1) + Api.ALL_LIVE_FOOT_URL;
                getLoadData(newUrl);
                i++;
            }
        });
    }

    private void getLoadData(String newUrl) {
        NetTool.getInstance().startRequest(newUrl, LiveBean.class, new onHttpCallBack<LiveBean>() {
            @Override
            public void onSuccess(LiveBean response) {

                adapter.addMore(response);

            }

            @Override
            public void onError(Throwable e) {
                Log.d("LiveFragment", e.getMessage());
            }
        });
    }

    @Override
    protected void initData() {
        getNetData();
    }

    private void getNetData() {
        NetTool.getInstance().startRequest(Api.ALL_LIVE_URL, LiveBean.class, new onHttpCallBack<LiveBean>() {
            @Override
            public void onSuccess(LiveBean response) {
                adapter.setBean(response);
            }

            @Override
            public void onError(Throwable e) {
                Log.d("LiveFragment", e.getMessage());
            }
        });
    }
}
