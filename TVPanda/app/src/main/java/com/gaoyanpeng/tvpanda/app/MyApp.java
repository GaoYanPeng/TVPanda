package com.gaoyanpeng.tvpanda.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by 高研鹏 on 2016/12/21.
 */

public class MyApp extends Application {
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static Context getContext() {
        return mContext;
    }
}
