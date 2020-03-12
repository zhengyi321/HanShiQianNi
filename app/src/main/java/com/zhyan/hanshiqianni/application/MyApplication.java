package com.zhyan.hanshiqianni.application;

import android.app.Application;
import android.content.Context;


import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;


import java.io.File;

import butterknife.ButterKnife;


/**
 *非常好用的插件http://blog.csdn.net/liang5630/article/details/46366901/
 */
public class MyApplication extends Application {

    public static  MyApplication instance;


    @Override
    public void onCreate() {
        this.instance = this;

        super.onCreate();


        // 图片缓存初始化
        ImageLoaderConfiguration configuration=ImageLoaderConfiguration.createDefault(this);
        // setImageLoader(configuration);
        ImageLoader.getInstance().init(configuration);



    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }

    public  MyApplication getInstance() {
        return instance;
    }

    public static  MyApplication getContext() {

        return instance;
    }




}

