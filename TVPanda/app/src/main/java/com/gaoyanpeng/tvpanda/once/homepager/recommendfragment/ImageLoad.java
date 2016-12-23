package com.gaoyanpeng.tvpanda.once.homepager.recommendfragment;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoaderInterface;

/**
 * Created by 裴亮 on 16/12/21.
 */
public class ImageLoad implements ImageLoaderInterface {

    @Override
    public void displayImage(Context context, Object path, View imageView) {
        Glide.with(context).load(path).into((ImageView) imageView);
    }

    @Override
    public View createImageView(Context context) {
        return null;
    }
}
