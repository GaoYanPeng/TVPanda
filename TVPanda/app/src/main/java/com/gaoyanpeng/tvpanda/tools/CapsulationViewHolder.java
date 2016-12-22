package com.gaoyanpeng.tvpanda.tools;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by 高研鹏 on 2016/12/21.
 */

public class CapsulationViewHolder extends RecyclerView.ViewHolder {
    //SparseArray 用法和 HashMap 相似
    //但是 Key 固定是 int 类型
    //用他来存放所有的 View,key 就是 View 的 id;
    private SparseArray<View> views;
    private View itemView;//行布局 视图

    public CapsulationViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        views = new SparseArray<>();
    }

    /**
     * 通过 View 的 ID 来获得指定的 View;
     * 如果该 View没有赋值,就先执行 findViewById
     * 然后把他放到View集合里
     * 使用泛型来取消强转
     *
     * @param id
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int id) {
        View view = views.get(id);
        if (view == null) {
            //证明SparseArray里没有这个 view
            view = itemView.findViewById(id);
            views.put(id, view);
        }
        return (T) view;
    }

    /**
     * 专门给 ListView 使用的方法
     *
     * @param itemView
     * @param viewGroup
     * @param layoutItemId
     * @return
     */
    public static CapsulationViewHolder
    getViewHolder(View itemView,
                  ViewGroup viewGroup, int layoutItemId) {
        CapsulationViewHolder holder;
        if (itemView == null) {
            Context mContext = viewGroup.getContext();
            itemView = LayoutInflater.from(mContext).inflate
                    (layoutItemId, viewGroup, false);
            holder = new CapsulationViewHolder(itemView);
            itemView.setTag(holder);
        } else {
            holder = (CapsulationViewHolder) itemView.getTag();
        }
        return holder;
    }

    /**
     * 构造方法重载,专门给 RecyclerView 的 Adapter 使用方法
     *
     * @param viewGroup
     * @param layoutItemId
     * @return
     */
    public static CapsulationViewHolder getViewHolder
    (ViewGroup viewGroup, int layoutItemId) {
        return getViewHolder(null, viewGroup, layoutItemId);
    }

    /**
     * 返回行布局
     *
     * @return
     */
    public View getItemView() {
        return itemView;
    }
//    ============设置数据的一些方法=====================

    /**
     * 设置文字
     *
     * @param id
     * @param text 内容
     * @return
     */
    public CapsulationViewHolder setText(int id, String text) {
        TextView textView = getView(id);
        textView.setText(text);
        return this;
    }

    /**
     * 设置图片,图片是 mimap里的
     *
     * @param imageViewId
     * @param imageView
     * @return
     */
    public CapsulationViewHolder setImage(int imageViewId, int imageView) {
        ImageView image = getView(imageViewId);
        image.setImageResource(imageView);
        return this;
    }

    /**
     * 设置 View 的点击事件
     * @param id
     * @param onClickListener
     * @return
     */
    public CapsulationViewHolder setViewClick
    (int id, View.OnClickListener onClickListener) {
        getView(id).setOnClickListener(onClickListener);
        return this;
    }
    public CapsulationViewHolder setItemClick
            (View.OnClickListener onClickListener){
        itemView.setOnClickListener(onClickListener);
        return  this;
    }
    public CapsulationViewHolder setTextColor(int id,int color){
        TextView textView = getView(id);
        textView.setTextColor(color);
        return this;
    }

}
