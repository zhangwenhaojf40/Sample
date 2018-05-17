package com.bao.tao.base.app;

import android.app.Application;

import com.bao.tao.base.dagger2.ComponentHolder;
import com.bao.tao.base.dagger2.compent.AppCompent;
import com.bao.tao.base.dagger2.compent.DaggerAppCompent;
import com.bao.tao.base.dagger2.module.AppModule;
import com.bao.tao.base.dagger2.module.ClientModule;



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

        AppCompent appCompent = DaggerAppCompent.builder()

                .clientModule(new ClientModule())
                .appModule(new AppModule(this)).build();
        ComponentHolder.setAppCompent(appCompent);





    }
    public static Application getApp() {
        return instans;
    }



}

