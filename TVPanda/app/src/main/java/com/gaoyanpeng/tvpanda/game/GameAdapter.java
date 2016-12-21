package com.gaoyanpeng.tvpanda.game;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gaoyanpeng.tvpanda.R;
import com.gaoyanpeng.tvpanda.onclick.RecyclerViewOnClick;


/**游戏页的适配器
 * Created by 高研鹏 on 2016/12/17.
 */

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameVH> {
    private Context mContext;
    //实现接口
    private RecyclerViewOnClick mRecyclerViewOnClick;
    private String mData;


    public GameAdapter setRecyclerViewOnClick(RecyclerViewOnClick recyclerViewOnClick) {
        mRecyclerViewOnClick = recyclerViewOnClick;
        return this;
    }

    public GameAdapter(Context context) {
        mContext = context;
    }

    private GameBean mGameBean;

    public GameAdapter setGameBean(GameBean gameBean) {
        mGameBean = gameBean;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public GameVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_come, parent,false);
        GameVH gameVH = new GameVH(view);
        return gameVH;
    }

    @Override
    public void onBindViewHolder(GameVH holder, final int position) {
        //名字
        holder.mGameName.setText(mGameBean.getData().get(position).getCname());
        //图片
       Glide.with(mContext).load(mGameBean.getData().get(position).getImg()).into(holder.mGameItemPic);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               mRecyclerViewOnClick.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mGameBean.getData().size();
    }

    class GameVH extends RecyclerView.ViewHolder {
        private ImageView mGameItemPic;
        private TextView mGameName;

        public GameVH(View itemView) {
            super(itemView);
            mGameItemPic = (ImageView) itemView.findViewById(R.id.game_item_pic);
            mGameName = (TextView) itemView.findViewById(R.id.game_item_name);
        }
    }
}
