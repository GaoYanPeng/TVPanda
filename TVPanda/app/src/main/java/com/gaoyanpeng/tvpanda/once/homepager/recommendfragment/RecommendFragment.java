package com.gaoyanpeng.tvpanda.once.homepager.recommendfragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.gaoyanpeng.tvpanda.R;
import com.gaoyanpeng.tvpanda.api.Api;
import com.gaoyanpeng.tvpanda.base.BaseFragment;
import com.gaoyanpeng.tvpanda.ok.NetTool;
import com.gaoyanpeng.tvpanda.ok.onHttpCallBack;
import com.github.jdsjlzx.interfaces.OnRefreshListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LRecyclerViewAdapter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 裴亮 on 16/12/22.
 */
public class RecommendFragment extends BaseFragment {
    private RecommendAdapter adapter;
    private List<String> list ; // 轮播图图片集合
    private List<String> bannerTitle; // 轮播图 标题集合
    private Banner banner;
    private LRecyclerView rv;
    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private View headView; // 轮播图

    @Override
    protected int initLayout() {
        return R.layout.fragment_common_home;
    }

    @Override
    protected void initView() {
        initViews();
        refreshListener(); // 刷新事件
    }

    private void refreshListener() {
        rv.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {

                //获取下方显示的数据
                getNetData();
                rv.refreshComplete();
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void initViews() {
        list = new ArrayList<>();
        bannerTitle = new ArrayList<>();
        rv = getFindView(R.id.rv_common);
        adapter = new RecommendAdapter();
        lRecyclerViewAdapter = new LRecyclerViewAdapter(adapter);
        rv.setAdapter(lRecyclerViewAdapter);
        rv.setLayoutManager(new LinearLayoutManager(mContext));
        //rv.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
        headView = LayoutInflater.from(mContext).inflate(R.layout.banner_common,null);
        banner = (Banner) headView.findViewById(R.id.banner_common);
        lRecyclerViewAdapter.addHeaderView(headView);
    }

    @Override
    protected void initData() {
        //获取下方显示的数据
        getNetData();
        // 获取轮播图数据
        getBannerNetData();
    }

    private void getBannerNetData() {
        NetTool.getInstance().startRequest(Api.RECOMMEND_BANNER_URL, BannerBean.class, new onHttpCallBack<BannerBean>() {
            @Override
            public void onSuccess(BannerBean response) {

                for (int i = 0; i < response.getData().size(); i++) {
                    list.add(response.getData().get(i).getBigimg());
//                    bannerTitle.add(response.getData().get(i).getTitle());
                }
                banner.setImages(list);
                banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
                banner.setImageLoader(new ImageLoad());
                banner.setBannerAnimation(Transformer.DepthPage);
//                banner.setBannerTitles(bannerTitle);
                banner.start();
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    private void getNetData() {
        NetTool.getInstance().startRequest(Api.RECOMMEND_URL, RecommendBean.class, new onHttpCallBack<RecommendBean>() {
            @Override
            public void onSuccess(RecommendBean response) {
                adapter.setBean(response);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
