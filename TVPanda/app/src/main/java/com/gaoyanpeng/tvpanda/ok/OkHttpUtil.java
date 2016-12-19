package com.gaoyanpeng.tvpanda.ok;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 高延鹏.on 16/8/30.
 */
public class OkHttpUtil implements NetInterface {
    private OkHttpClient mClient;
    //这样定义的handler对象无论在哪里创建的 都是属于主线程的
    private Handler mHandler =
            new Handler(Looper.getMainLooper());
    private Gson mGson;
    private String mResult;

    public OkHttpUtil() {
        super();
        mGson = new Gson();
        //获取系统的sd卡
        File path =
                Environment.getExternalStorageDirectory();
        //初始化okhttp
        mClient = new OkHttpClient.Builder()
                //设置缓存位置 以及缓存大小
                .cache(new Cache(path, 10 * 1024 * 1024))
                //超时时间5s
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();
    }

    @Override
    public void startRequest(String url, final onHttpCallBack<String> callBack) {
        final Request request = new Request.Builder()
                .url(url).build();
        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onError(e);
                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                mResult = response.body().string();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {

                        callBack.onSuccess(mResult);
                    }
                });
            }
        });
    }

    @Override
    public <T> void startRequest(String url, final Class<T> tClass, final onHttpCallBack<T> callBack) {
        Request request = new Request
                .Builder().url(url).build();
        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onError(e);
                    }
                });
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str = response.body().string();
                final T result = mGson.fromJson(str, tClass);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        callBack.onSuccess(result);
                    }
                });

            }
        });
    }
}
