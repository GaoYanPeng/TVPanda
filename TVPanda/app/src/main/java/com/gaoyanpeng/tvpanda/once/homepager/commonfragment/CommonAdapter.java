package com.gaoyanpeng.tvpanda.once.homepager.commonfragment;

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

public class CommonAdapter extends RecyclerView.Adapter<CommonAdapter.CommonViewHolder>{

    private CommonBean commonBean;
    private Context mContext;

    public void setCommonBean(CommonBean commonBean) {
        this.commonBean = commonBean;
        notifyDataSetChanged();
    }


    public void addMore(CommonBean bean) {
        commonBean.getData().getItems().addAll(bean.getData().getItems());
    }



    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_common_home,parent,false);
        CommonViewHolder commonViewHolder = new CommonViewHolder(view);
        return commonViewHolder;
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position) {
        Glide.with(mContext).load(commonBean.getData()
                .getItems().get(position).getPictures().getImg()).into(holder.pic);
        holder.desc.setText(commonBean.getData().getItems().get(position).getName());
        holder.username.setText(commonBean.getData().getItems().get(position).getUserinfo().getNickName());
        holder.watchCount.setText(commonBean.getData().getItems().get(position).getPerson_num());
    }

    @Override
    public int getItemCount() {
        return commonBean == null ? 0 : commonBean.getData().getItems().size();
    }

    public class CommonViewHolder extends RecyclerView.ViewHolder {
        private ImageView pic;
        private TextView desc;
        private TextView username;
        private TextView watchCount;
        public CommonViewHolder(View itemView) {
            super(itemView);
            pic = (ImageView) itemView.findViewById(R.id.iv_pic_item_recommend);
            desc = (TextView) itemView.findViewById(R.id.tv_title_item_pic_recommend);
            username = (TextView) itemView.findViewById(R.id.tv_username_pic_item_recommend);
            watchCount = (TextView) itemView.findViewById(R.id.tv_count_item_pic_recommend);
        }
    }
}
