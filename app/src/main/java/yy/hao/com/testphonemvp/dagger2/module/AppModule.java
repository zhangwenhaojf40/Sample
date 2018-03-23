package yy.hao.com.testphonemvp.dagger2.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator
 * on 2018/3/20 0020.
 */
@Module(includes = ClientModule.class)
public class AppModule {
    Application application;
    public AppModule(Application application) {
        this.application = application;

    }

    @Provides
    @Singleton
    public Application provideApp() {
        return application;
    }

}
