package com.gaoyanpeng.tvpanda.ok;

/**
 * Created by 高延鹏.on 16/8/30.
 */
public interface onHttpCallBack <T>{
    void onSuccess(T response);
    void onError(Throwable e);

}
