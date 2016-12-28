package com.gaoyanpeng.tvpanda.once.game.gamedetails.gamedatailsitem;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.gaoyanpeng.tvpanda.R;
import com.gaoyanpeng.tvpanda.tools.CapsulationViewHolder;

/**
 * Created by 高研鹏 on 2016/12/28.
 */

public class GameItemAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private GameItemBean mGameItemBean;

    public GameItemAdapter(Context context) {
        mContext = context;
    }

    public GameItemAdapter setGameItemBean(GameItemBean gameItemBean) {
        mGameItemBean = gameItemBean;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CapsulationViewHolder holder ;
        holder = CapsulationViewHolder.getViewHolder(parent, R.layout.item_item_game);

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
