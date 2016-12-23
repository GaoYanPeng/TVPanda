package com.gaoyanpeng.tvpanda.once.game.gamedetails;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gaoyanpeng.tvpanda.R;
import com.gaoyanpeng.tvpanda.api.Api;
import com.gaoyanpeng.tvpanda.base.BaseActivity;
import com.gaoyanpeng.tvpanda.ok.NetTool;
import com.gaoyanpeng.tvpanda.ok.onHttpCallBack;

/**
 * Created by 高研鹏 on 2016/12/20.
 */

public class GameDetailsAty extends BaseActivity implements View.OnClickListener {
    private TextView mGameDetailsTitle;
    /**
     * 传过来的 title
     */
    private String mTitle;
    private static String PHAT = "";
    private String data;
    private RecyclerView mRecyclerView;
    private GameDetailsAdapter mGameDetailsAdapter;
    private GridLayoutManager mGridLayoutManager;
    private ImageView mReturn;

    @Override
    protected int getLayout() {
        return R.layout.aty_game_details;
    }

    @Override
    public void initView() {
        mGameDetailsTitle = findView(R.id.game_details_title);
        mRecyclerView = findView(R.id.details_Ryl);
        mGameDetailsAdapter = new GameDetailsAdapter(getBaseContext());
        mGridLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mGridLayoutManager);
        mReturn = findView(R.id.deta_left_return);
    }

    @Override
    protected void initThis() {
mReturn.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        mTitle = intent.getStringExtra("title");
        mGameDetailsTitle.setText(mTitle);
        data = intent.getStringExtra("enDa");
        PHAT = Api.CAME_FRONT + data + Api.CAME_BACK;

        Log.d("GameDetailsAty", PHAT);
        NetTool.getInstance().startRequest(PHAT, GameDetailsBean.class, new onHttpCallBack<GameDetailsBean>() {
            @Override
            public void onSuccess(GameDetailsBean response) {
                mGameDetailsAdapter.setGameDetailsBean(response.getData());
                mRecyclerView.setAdapter(mGameDetailsAdapter);

            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        finish();
    }
}