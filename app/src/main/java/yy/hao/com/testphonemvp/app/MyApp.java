package yy.hao.com.testphonemvp.app;

import android.app.Application;

import yy.hao.com.testphonemvp.dagger2.AppCompent;
import yy.hao.com.testphonemvp.dagger2.ComponentHolder;

import yy.hao.com.testphonemvp.dagger2.DaggerAppCompent;
import yy.hao.com.testphonemvp.dagger2.module.AppModule;

/**
 * Created by Administrator
 * on 2018/3/20 0020.
 */

public class MyApp extends Application {

    static MyApp instans;
    @Override
    public void onCreate() {
        super.onCreate();
        instans = this;
        AppCompent appCompent = DaggerAppCompent.builder().appModule(new AppModule(this)).build();
        ComponentHolder.setAppCompent(appCompent);
    }
    public static Application getApp() {
        return instans;
    }



}

