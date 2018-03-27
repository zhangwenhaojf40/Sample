package yy.hao.com.testphonemvp.app;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

import yy.hao.com.testphonemvp.dagger2.ComponentHolder;

import yy.hao.com.testphonemvp.dagger2.compent.AppCompent;
import yy.hao.com.testphonemvp.dagger2.compent.DaggerAppCompent;
import yy.hao.com.testphonemvp.dagger2.module.AppModule;
import yy.hao.com.testphonemvp.dagger2.module.ClientModule;

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
        ARouter.init(this);
        AppCompent appCompent = DaggerAppCompent.builder()

                .clientModule(new ClientModule())
                .appModule(new AppModule(this)).build();
        ComponentHolder.setAppCompent(appCompent);
    }
    public static Application getApp() {
        return instans;
    }



}

