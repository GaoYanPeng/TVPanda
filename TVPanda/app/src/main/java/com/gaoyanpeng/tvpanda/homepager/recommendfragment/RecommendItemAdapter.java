package com.gaoyanpeng.tvpanda.homepager.recommendfragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gaoyanpeng.tvpanda.R;


import java.util.List;

/**推荐每一行里的 Recycler Item
 * Created by 裴亮 on 16/12/21.
 */

public class RecommendItemAdapter extends RecyclerView.Adapter<RecommendItemAdapter.RecommendItemViewHolder> {

   private List<RecommendBean.DataBean.ItemsBean> beanList;
    private Context mContext;

    public void setBeanList(List<RecommendBean.DataBean.ItemsBean> beanList) {
        this.beanList = beanList;
        Log.d("RecommendItemAdapter", "beanList:" + beanList);
        notifyDataSetChanged();
    }

    @Override
    public void onViewAttachedToWindow(RecommendItemViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        View view = holder.itemView;
        TranslateAnimation translateAnimation = new TranslateAnimation(500, 0, 0, 0);
        translateAnimation.setDuration(200);
        view.setAnimation(translateAnimation);
        translateAnimation.start();
    }

    @Override
    public RecommendItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recommend_pic,parent,false);
        RecommendItemViewHolder viewHolder = new RecommendItemViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecommendItemViewHolder holder, int position) {
        Glide.with(mContext).load(beanList.get(position).getPictures().getImg()).into(holder.pic);
        holder.desc.setText(beanList.get(position).getName());
        holder.username.setText(beanList.get(position).getUserinfo().getNickName());
        holder.watchCount.setText(beanList.get(position).getPerson_num());

    }

    @Override
    public int getItemCount() {
        return beanList == null ? 0 : beanList.size();
    }

    public class RecommendItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView pic;
        private TextView desc;
        private TextView username;
        private TextView watchCount;
        public RecommendItemViewHolder(View itemView) {
            super(itemView);
            pic = (ImageView) itemView.findViewById(R.id.iv_pic_item_recommend_t);
            desc = (TextView) itemView.findViewById(R.id.tv_title_item_pic_recommend_t);
            username = (TextView) itemView.findViewById(R.id.tv_username_pic_item_recommend_t);
            watchCount = (TextView) itemView.findViewById(R.id.tv_count_item_pic_recommend_t);
        }
    }
}
