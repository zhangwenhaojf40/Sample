package yy.hao.com.testphonemvp.dagger2.compent;

import dagger.Component;
import yy.hao.com.testphonemvp.dagger2.ActivityScope;


import yy.hao.com.testphonemvp.dagger2.module.ApiModule;
import yy.hao.com.testphonemvp.present.NewsFragmentPresent;
import yy.hao.com.testphonemvp.view.MainActivity;
import yy.hao.com.testphonemvp.view.PhoneActivity;
import yy.hao.com.testphonemvp.view.SplashActivity;
import yy.hao.com.testphonemvp.view.fragment.NewsFragment;

/**
 * Created by Administrator
 * on 2018/3/20 0020.
 */
@ActivityScope
@Component(modules = ApiModule.class, dependencies = AppCompent.class)
public interface ApiCompent {

    void inject(MainActivity activity);

    void inject(PhoneActivity activity);

    void inject(SplashActivity activity);

    void inject(NewsFragment activity);



}
