package yy.hao.com.testphonemvp.dagger2.module;

import dagger.Module;
import dagger.Provides;
import yy.hao.com.testphonemvp.m.Student;
import yy.hao.com.testphonemvp.view.PhoneActivity;

/**
 * Created by Administrator
 * on 2018/3/20 0020.
 */
@Module
public class ApiModule {
    @Provides
    Student provide() {
        return new Student();
    }
}
