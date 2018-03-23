package yy.hao.com.testphonemvp.dagger2.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import yy.hao.com.testphonemvp.net.ApiService;
import yy.hao.com.testphonemvp.net.NetUtils;

/**
 * Created by Administrator
 * on 2018/3/21 0021.
 */
@Module
public class ClientModule {

    @Provides
    @Singleton
    public ApiService provide() {
        OkHttpClient client = new OkHttpClient.Builder().build();
        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加响应式编程的适配器
                .baseUrl(NetUtils.BASEURL)
                .client(client)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        return apiService;
    }
}
