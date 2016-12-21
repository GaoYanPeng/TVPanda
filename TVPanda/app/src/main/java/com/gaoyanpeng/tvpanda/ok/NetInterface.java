package com.gaoyanpeng.tvpanda.ok;

/**
 * Created by 高延鹏.on 16/12/20.
 */
public interface NetInterface {
    void startRequest(String url, onHttpCallBack<String> callBack);
    <T> void startRequest(String url,
                          Class<T> tClass
            , onHttpCallBack<T> callBack);
}
