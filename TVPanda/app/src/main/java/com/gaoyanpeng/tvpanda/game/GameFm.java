package com.gaoyanpeng.tvpanda.game;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.gaoyanpeng.tvpanda.R;
import com.gaoyanpeng.tvpanda.api.Api;
import com.gaoyanpeng.tvpanda.base.BaseFragment;
import com.gaoyanpeng.tvpanda.game.gamedetails.GameDetailsAty;
import com.gaoyanpeng.tvpanda.ok.NetTool;
import com.gaoyanpeng.tvpanda.ok.onHttpCallBack;
import com.gaoyanpeng.tvpanda.onclick.RecyclerViewOnClick;


/**
 * 游戏
 * Created by 高研鹏 on 2016/12/17.
 */

public class GameFm extends BaseFragment {
    private RecyclerView mGameRecyclerView;
    private GameAdapter mGameAdapter;


    /**
     * 点击行布局跳转传入的标题
     */
    private String mTitle;
    /**
     * 点击行布局跳转传入的拼接用的数据
     */
    private String mEnDa;

    @Override
    protected int initLayout() {
        return R.layout.fm_game;
    }

    @Override
    protected void initView() {
//        绑定ID
        mGameRecyclerView = getFindView(R.id.game_ryl);
        //初始化适配器
        mGameAdapter = new GameAdapter(getContext());
        //RecyclerView 管理器
        GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
        //RecyclerView 设置管理器
        mGameRecyclerView.setLayoutManager(manager);

    }

    @Override
    protected void initData() {
        //Ok
        NetTool.getInstance().startRequest(Api.CAME, GameBean.class, new onHttpCallBack<GameBean>() {
            @Override
            public void onSuccess(final GameBean response) {
                mGameAdapter.setGameBean(response);
                mGameRecyclerView.setAdapter(mGameAdapter);
                mGameAdapter.setRecyclerViewOnClick(new RecyclerViewOnClick() {
                    @Override
                    public void onClick(int pos) {
                        Intent intent = new Intent(getContext(), GameDetailsAty.class);
                        mTitle = response.getData().get(pos).getCname();
                        intent.putExtra("title", mTitle);
                        mEnDa =response.getData().get(pos).getEname();
                        intent.putExtra("enDa", mEnDa);
                        startActivity(intent);

                    }
                });
            }

            @Override
            public void onError(Throwable e) {

            }
        });

    }


}
