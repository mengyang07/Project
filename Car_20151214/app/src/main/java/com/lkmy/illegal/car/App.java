package com.lkmy.illegal.car;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;

import com.baidu.mobstat.StatService;
import com.lkmy.illegal.car.engine.Engine;
import com.lkmy.illegal.car.util.version.StoredVersionData;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * 作者:李凯
 * 创建时间:2015/11/13 00:15
 * 描述:
 */
public class App extends Application {
    private static App sInstance;
    private Engine mEngine;

    private String HTTP_JSON = "http://7xk9dj.com1.z0.glb.clouddn.com/";


    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        initBaiduMobstat();
        mEngine = new Retrofit.Builder()
                .baseUrl("http://10.0.3.2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(Engine.class);
        initImageLoader(this);
        StoredVersionData.getThis().markOpenApp(this);

        startBackgroundService();

    }

    public static App getInstance() {

        return sInstance;
    }

    public Engine getEngine() {

        return mEngine;
    }

    private void initBaiduMobstat() {
        StatService.setAppKey("d5688651a2");
        StatService.setDebugOn(true);
        StatService.setAppChannel(this, "self", true);
    }

    private void startBackgroundService() {
        Intent intent = new Intent(getInstance(), BgService.class);
        startService(intent);
    }

    private void initImageLoader(Context context) {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .threadPriority(Thread.NORM_PRIORITY)
                .diskCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .defaultDisplayImageOptions(getImgOptions())
                .build();
        ImageLoader.getInstance().init(config);

    }

    private static DisplayImageOptions getImgOptions() {
        DisplayImageOptions imgOptions = new DisplayImageOptions.Builder()
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
//                .showImageOnLoading(R.mipmap.holder)
//                .showImageForEmptyUri(R.mipmap.holder)
//                .showImageOnFail(R.mipmap.holder)
                .build();
        return imgOptions;
    }

}