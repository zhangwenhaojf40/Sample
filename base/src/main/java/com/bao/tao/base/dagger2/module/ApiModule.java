package com.bao.tao.base.dagger2.module;

import com.bao.tao.base.m.Student;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator
 * on 2018/3/20 0020.
 */
@Module(includes = ActivityModule.class)
public class ApiModule {
    @Provides
    Student provide() {
        return new Student();
    }
}
