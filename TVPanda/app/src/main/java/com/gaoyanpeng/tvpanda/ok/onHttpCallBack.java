package com.gaoyanpeng.tvpanda.ok;

/**
 * Created by 高延鹏.on 16/12/20.
 */
public interface onHttpCallBack <T>{
    void onSuccess(T response);
    void onError(Throwable e);

}
