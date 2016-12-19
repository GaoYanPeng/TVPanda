package com.gaoyanpeng.tvpanda.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by dllo on 16/8/2.
 */
public abstract  class BaseFragment extends Fragment {

    protected Context mContext;
    //这里主要目的就是获取content对象

    /**
     * 自己手动覆写onAttach()方法 覆写参数是context的
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(initLayout(),container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initView();
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }
    protected  abstract  int initLayout();
    protected  abstract  void initView();
    protected  abstract  void initData();
    public <T extends View>T getFindView(int id){
        return (T) getView().findViewById(id);
    }

}
