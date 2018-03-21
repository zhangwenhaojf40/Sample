package yy.hao.com.testphonemvp.dagger2;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import yy.hao.com.testphonemvp.app.MyApp;
import yy.hao.com.testphonemvp.dagger2.module.AppModule;
import yy.hao.com.testphonemvp.m.Student;

/**
 * Created by Administrator
 * on 2018/3/20 0020.
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppCompent {

    Application myApplication();


}
