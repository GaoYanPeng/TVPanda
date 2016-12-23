package com.gaoyanpeng.tvpanda.once.live;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.gaoyanpeng.tvpanda.R;
import com.gaoyanpeng.tvpanda.onclick.RecyclerViewOnClick;
import com.gaoyanpeng.tvpanda.tools.CapsulationViewHolder;

/**
 * Created by Administrator on 2016/12/20.
 * 复用娱乐中，RecyclerView的适配器
 */

public class LiveRVAdapter extends RecyclerView.Adapter {

    private LiveBean.DataBean mLiveBeanArrayList;
//    接口回调
    private RecyclerViewOnClick mRecyclerViewOnClick;

    public void setLiveBeanArrayList(LiveBean.DataBean liveBeanArrayList) {
        mLiveBeanArrayList = liveBeanArrayList;
    }

    public void setRecyclerViewOnClick(RecyclerViewOnClick recyclerViewOnClick) {
        mRecyclerViewOnClick = recyclerViewOnClick;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        封装的viewholder
        CapsulationViewHolder capsulationViewHolder;

        capsulationViewHolder = CapsulationViewHolder.getViewHolder(parent, R.layout.item_live);
        return capsulationViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        CapsulationViewHolder capsulationViewHolder = (CapsulationViewHolder) holder;
//        获取图片,标题，主播直播间的名字
        String Image = mLiveBeanArrayList.getItems().get(position).getPictures().getImg();
        String title = mLiveBeanArrayList.getItems().get(position).getName();
        String anchor = mLiveBeanArrayList.getItems().get(position).getUserinfo().getNickName();
        String person = mLiveBeanArrayList.getItems().get(position).getPerson_num();
//        把数据赋给相应的控件
        capsulationViewHolder.setNetImage(R.id.live_image,Image);
        capsulationViewHolder.setText(R.id.live_title,title);
        capsulationViewHolder.setText(R.id.live_anchor_name,anchor);
        capsulationViewHolder.setText(R.id.live_looking_peoples,person);
    }

    @Override
    public int getItemCount() {
        return mLiveBeanArrayList == null ? 0 :mLiveBeanArrayList.getItems().size();
    }

}
