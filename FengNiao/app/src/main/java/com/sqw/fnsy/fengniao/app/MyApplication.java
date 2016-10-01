package com.sqw.fnsy.fengniao.app;

import android.app.Application;
import android.graphics.Bitmap;

import com.squareup.picasso.LruCache;
import com.squareup.picasso.Picasso;

/**
 * Created by SUN on 2016/10/1.
 */

public class MyApplication extends Application {

    private Picasso picasso = null;

    @Override
    public void onCreate() {
        super.onCreate();
        setPicassoConfig();
    }

    private void setPicassoConfig() {
        picasso = new Picasso.Builder(this)
                .memoryCache(new LruCache(10 << 20))
                .defaultBitmapConfig(Bitmap.Config.RGB_565)
                .build();
        Picasso.setSingletonInstance(picasso);
    }
}
