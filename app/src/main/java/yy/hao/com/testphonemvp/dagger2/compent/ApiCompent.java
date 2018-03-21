package yy.hao.com.testphonemvp.dagger2.compent;

import dagger.Component;
import dagger.Provides;
import yy.hao.com.testphonemvp.dagger2.ActivityScope;
import yy.hao.com.testphonemvp.dagger2.AppCompent;
import yy.hao.com.testphonemvp.dagger2.module.ApiModule;
import yy.hao.com.testphonemvp.dagger2.module.AppModule;
import yy.hao.com.testphonemvp.m.Student;
import yy.hao.com.testphonemvp.view.MainActivity;
import yy.hao.com.testphonemvp.view.PhoneActivity;

/**
 * Created by Administrator
 * on 2018/3/20 0020.
 */
@ActivityScope
@Component(modules =ApiModule.class,dependencies = AppCompent.class)
public interface ApiCompent {

    void inject(MainActivity activity);
    void inject(PhoneActivity activity);



}
