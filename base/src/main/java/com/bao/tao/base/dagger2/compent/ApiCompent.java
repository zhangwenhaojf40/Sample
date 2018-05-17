package com.bao.tao.base.dagger2.compent;

import com.bao.tao.base.dagger2.ActivityScope;
import com.bao.tao.base.dagger2.module.ApiModule;
import com.bao.tao.base.view.PhoneActivity;
import com.bao.tao.base.view.fragment.NewsFragment;

import dagger.Component;


/**
 * Created by Administrator
 * on 2018/3/20 0020.
 */
@ActivityScope
@Component(modules = ApiModule.class, dependencies = AppCompent.class)
public interface ApiCompent {


    void inject(PhoneActivity activity);


    void inject(NewsFragment activity);



}
