package com.gaoyanpeng.tvpanda.ok;

/**
 * Created by 高延鹏.on 16/8/30.
 */
public class NetTool  implements NetInterface{
    private static NetTool ourInstance;
    private NetInterface mNetInterface;

    public static NetTool getInstance() {
        if (ourInstance == null){
            synchronized (NetTool.class){
                if (ourInstance == null){
                    ourInstance = new NetTool();
                }
            }
        }
        return ourInstance;
    }
    private NetTool() {
        mNetInterface = new OkHttpUtil();
    }
    @Override
    public void startRequest(String url, onHttpCallBack<String> callBack) {
        mNetInterface.startRequest(url,callBack);
    }

    @Override
    public <T> void startRequest(String url, Class<T> tClass, onHttpCallBack<T> callBack) {

        mNetInterface.startRequest(url,tClass,callBack);
    }
}
