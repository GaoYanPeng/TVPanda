package com.gaoyanpeng.tvpanda.once.game.gamedetails.gamedatailsitem;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.gaoyanpeng.tvpanda.R;
import com.gaoyanpeng.tvpanda.api.Api;
import com.gaoyanpeng.tvpanda.base.BaseActivity;
import com.gaoyanpeng.tvpanda.ok.NetTool;
import com.gaoyanpeng.tvpanda.ok.onHttpCallBack;

/**
 * Created by 高研鹏 on 2016/12/28.
 */

public class GameItemAty extends BaseActivity {
    private WebView mWebView;
    private WebSettings mWebSettings;
    private String mId;
    private String mPath;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected int getLayout() {
        return R.layout.aty_game_item_item;
    }

    @Override
    public void initView() {
        mWebView = findView(R.id.item_game_web);
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.setFocusable(true);
        mWebSettings = mWebView.getSettings();
        mWebSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        mWebSettings.setJavaScriptEnabled(true);
        mWebSettings.setSupportZoom(true);
        mWebSettings.setUseWideViewPort(true);
        mWebSettings.setLoadWithOverviewMode(true);
        mWebSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        //==============================
        mTabLayout = findView(R.id.game_item_tab);
        mViewPager = findView(R.id.game_item_vp);

    }

    @Override
    protected void initThis() {

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        mId = intent.getStringExtra("id");
        mPath = Api.UrlHeard + mId + Api.UrlHou;
        Log.d("GameItemAty", mPath);
        NetTool.getInstance().startRequest(mPath, GameItemBean.class, new onHttpCallBack<GameItemBean>() {
            @Override
            public void onSuccess(GameItemBean response) {
                String id = response.getData().getInfo().getRoominfo().getId();
                String Url = Api.URLID + id;
                Log.d("GameItemAty", Url);
                mWebView.loadUrl(Url);
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }
}
