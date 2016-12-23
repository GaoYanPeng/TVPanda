package com.gaoyanpeng.tvpanda.once.game.gamedetails;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.gaoyanpeng.tvpanda.R;
import com.gaoyanpeng.tvpanda.tools.CapsulationViewHolder;

/**
 * Game 行布局详情的 Adapter
 * Created by 高研鹏 on 2016/12/21.
 */

public class GameDetailsAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private GameDetailsBean.DataBean mGameDetailsBean;

    public GameDetailsAdapter(Context context) {
        mContext = context;
    }

    public GameDetailsAdapter setGameDetailsBean(GameDetailsBean.DataBean gameDetailsBean) {
        mGameDetailsBean = gameDetailsBean;
        return this;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CapsulationViewHolder capsulationViewHolder;
        capsulationViewHolder = CapsulationViewHolder.getViewHolder(parent, R.layout.item_come_datails);
        return capsulationViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CapsulationViewHolder viewHolder = (CapsulationViewHolder) holder;
        viewHolder.setNetImage(R.id.game_data_pictures, mGameDetailsBean.getItems().get(position).getPictures().getImg());
//person_num
            viewHolder.setText(R.id.deta_item_nick_name, mGameDetailsBean.getItems().get(position).getUserinfo().getNickName());
            viewHolder.setText(R.id.data_item_name, mGameDetailsBean.getItems().get(position).getName());


    }

    @Override
    public int getItemCount() {
        return mGameDetailsBean.getItems().size();
    }
}
