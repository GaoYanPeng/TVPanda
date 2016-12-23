package com.gaoyanpeng.tvpanda.once.homepager.recommendfragment;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.gaoyanpeng.tvpanda.R;


import java.util.ArrayList;
import java.util.List;

/**推荐自己的
 * Created by 裴亮 on 16/12/21.
 */

public class RecommendAdapter extends RecyclerView.Adapter {

    private RecommendBean bean;
    private Context mContext;
    private List<RecommendBean.DataBean.ItemsBean> list;

    public RecommendAdapter() {
        list = new ArrayList<>();
    }

    public void setBean(RecommendBean bean) {
        this.bean = bean;
        Log.d("RecommendAdapter", "bean:" + bean);
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_recommend,parent,false);
        RecommendViewHolder viewHolder = new RecommendViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RecommendViewHolder  recommendViewHolder = (RecommendViewHolder) holder;

        recommendViewHolder.title.setText(bean.getData().get(position).getType().getCname());
        Glide.with(mContext).load(bean.getData().get(position).getType().
                getIcon()).into(recommendViewHolder.icon);


        RecommendItemAdapter recommendItemAdapter = new RecommendItemAdapter();
        list = bean.getData().get(position).getItems();
        Log.d("RecommendAdapter", "list:" + list);
        recommendItemAdapter.setBeanList(list);
        recommendViewHolder.rv.setAdapter(recommendItemAdapter);
        recommendViewHolder.rv.setLayoutManager(new GridLayoutManager(mContext,2));


    }

    @Override
    public int getItemCount() {
        return bean == null ? 0 : bean.getData().size();
    }
    class RecommendViewHolder extends RecyclerView.ViewHolder{
        private ImageView icon;
        private TextView title;
        private RecyclerView rv;

        public RecommendViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.iv_icon_item_recommend);
            title = (TextView) itemView.findViewById(R.id.tv_title_item_recommend);
            rv = (RecyclerView) itemView.findViewById(R.id.rv_item_recommend);
        }
    }
}
