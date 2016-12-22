package com.gaoyanpeng.tvpanda.homepager.commonfragment;

import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;

import com.gaoyanpeng.tvpanda.R;
import com.gaoyanpeng.tvpanda.api.Api;
import com.gaoyanpeng.tvpanda.base.BaseFragment;
import com.gaoyanpeng.tvpanda.homepager.recommendfragment.ImageLoad;
import com.gaoyanpeng.tvpanda.homepager.tab.TabAdapter;
import com.gaoyanpeng.tvpanda.ok.NetTool;
import com.gaoyanpeng.tvpanda.ok.onHttpCallBack;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
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
public class CommonFragment extends BaseFragment {
    private String url; // 拼接之后网址
    private CommonAdapter commonAdapter;
    private LRecyclerView rv;
    private Banner banner;
    private List<String> list; // 轮播图图片数量的集合
    private List<String> titleList; // 轮播图标题数量的集合
    private String name; // 拼接字段的内容
    private int i = 1; // 初始页
    private String newUrl; // 加载拼接网址
    private LRecyclerViewAdapter lRecyclerViewAdapter;
    private View headView;

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
        rv = getFindView(R.id.rv_common);
        Bundle bundle = getArguments();
        if (bundle != null) {
            name = bundle.getString("data");
            url = Api.HOME_REUSE_HEAD_URL + name + Api.HOME_REUSE_FOOT_URL;
        }
        list = new ArrayList<>();
        titleList = new ArrayList<>();
        commonAdapter = new CommonAdapter();
        lRecyclerViewAdapter = new LRecyclerViewAdapter(commonAdapter);
        rv.setAdapter(lRecyclerViewAdapter);
        rv.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        headView = LayoutInflater.from(mContext).inflate(R.layout.banner_common, null);
        banner = (Banner) headView.findViewById(R.id.banner_common);
        lRecyclerViewAdapter.addHeaderView(headView);
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
                newUrl = Api.HOME_REUSE_HEAD_URL + name+ Api.HOME_REUSE_PAGE_URL + (i + 1) +
                Api.HOME_REUSE_PAGE_LOAD_URL;
                getLoadData(newUrl);
                i++;
            }
        });
    }

    private void getLoadData(String newUrl) {
        NetTool.getInstance().startRequest(newUrl, CommonBean.class, new onHttpCallBack<CommonBean>() {
            @Override
            public void onSuccess(CommonBean response) {
                commonAdapter.addMore(response);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    @Override
    protected void initData() {
        getNetData();
    }

    private void getNetData() {
        NetTool.getInstance().startRequest(url, CommonBean.class, new onHttpCallBack<CommonBean>() {
            @Override
            public void onSuccess(CommonBean response) {
                commonAdapter.setCommonBean(response);
                for (int i = 0; i < response.getData().getBanners().size(); i++) {
                    list.add(response.getData().getBanners().get(i).getBigimg());
                    //titleList.add(response.getData().getBanners().get(i).getTitle());
                }
                if (list.size() == 0){
                    banner.setVisibility(View.GONE);
                }else {
                    banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
                    banner.setImages(list);
                    banner.setImageLoader(new ImageLoad());
                    banner.setBannerAnimation(Transformer.DepthPage);
                    //先不要了
                   // banner.setBannerTitles(titleList);
                    banner.start();
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }


    public static CommonFragment newInstance(int position) {

        Bundle args = new Bundle();
        String data = TabAdapter.getData(position);
        args.putString("data", data);
        CommonFragment fragment = new CommonFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
