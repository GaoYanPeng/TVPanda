package com.gaoyanpeng.tvpanda.once.homepager.livefragment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gaoyanpeng.tvpanda.R;


/**
 * Created by 裴亮 on 16/12/21.
 */

public class LiveAdapter extends RecyclerView.Adapter<LiveAdapter.LiveViewHolder> {

    private LiveBean bean;
    private Context mContext;

    public void setBean(LiveBean bean) {
        this.bean = bean;
        notifyDataSetChanged();
    }

    public void addMore(LiveBean liveBean) {
        bean.getData().getItems().addAll(liveBean.getData().getItems());
    }



    @Override
    public LiveViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_common_home,parent,false);
        LiveViewHolder viewHolder = new LiveViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(LiveViewHolder holder, int position) {
        Glide.with(mContext).load(bean.getData()
                .getItems().get(position).getPictures().getImg()).into(holder.pic);
        holder.desc.setText(bean.getData().getItems().get(position).getName());
        holder.username.setText(bean.getData().getItems().get(position).getUserinfo().getNickName());
        holder.watchCount.setText(bean.getData().getItems().get(position).getPerson_num());
    }

    @Override
    public int getItemCount() {
        return bean == null ? 0 : bean.getData().getItems().size();
    }

    public class LiveViewHolder extends RecyclerView.ViewHolder {
        private ImageView pic;
        private TextView desc;
        private TextView username;
        private TextView watchCount;
        public LiveViewHolder(View itemView) {
            super(itemView);
            pic = (ImageView) itemView.findViewById(R.id.iv_pic_item_recommend);
            desc = (TextView) itemView.findViewById(R.id.tv_title_item_pic_recommend);
            username = (TextView) itemView.findViewById(R.id.tv_username_pic_item_recommend);
            watchCount = (TextView) itemView.findViewById(R.id.tv_count_item_pic_recommend);
        }
    }
}
