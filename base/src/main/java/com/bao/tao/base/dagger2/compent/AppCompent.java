package com.bao.tao.base.dagger2.compent;


import android.app.Application;

import com.bao.tao.base.dagger2.module.AppModule;
import com.bao.tao.base.net.ApiService;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator
 * on 2018/3/20 0020.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppCompent {

    Application myApplication();

    ApiService apiService();
}
