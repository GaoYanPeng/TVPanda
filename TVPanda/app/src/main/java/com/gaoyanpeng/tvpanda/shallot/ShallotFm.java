package com.gaoyanpeng.tvpanda.shallot;


import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.gaoyanpeng.tvpanda.R;
import com.gaoyanpeng.tvpanda.api.Api;
import com.gaoyanpeng.tvpanda.base.BaseFragment;

/**小葱秀
 * Created by 高研鹏 on 2016/12/17.
 */

public class ShallotFm extends BaseFragment {
    private WebView mWebView;
    private WebViewClient mWebViewClient;
    private WebSettings mWebSettings;
    @Override
    protected int initLayout() {
        return R.layout.fm_shallot;
    }

    @Override
    protected void initView() {
       mWebView =  getFindView(R.id.shall_wb);

    }

    @Override
    protected void initData() {
        mWebViewClient = new WebViewClient();
        mWebView.setWebViewClient(mWebViewClient);
        mWebView.setFocusable(true);
        mWebSettings = mWebView.getSettings();
        mWebSettings.setJavaScriptEnabled(true);
        mWebSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        mWebView.loadUrl(Api.SMALL);

    }
}
