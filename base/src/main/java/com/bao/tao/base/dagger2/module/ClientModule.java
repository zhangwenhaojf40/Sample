package com.bao.tao.base.dagger2.module;

import android.util.Log;

import com.bao.tao.base.http.NetUrl;
import com.bao.tao.base.net.ApiService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ZhangWenHao
 * on 2018/2/23 0023.
 */
@Module
public class ClientModule {
    private static final long DEFAULT_TIMEOUT = 30;//超时时间
    @Provides
    @Singleton
    ApiService provideApi() {
        return initRetrofit().create(ApiService.class);
    }
    public Retrofit initRetrofit() {
        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.BODY;
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("HttpManager", message);
            }
        });
        loggingInterceptor.setLevel(level);
        //拦截请求和响应日志并输出，其实有很多封装好的日志拦截插件，大家也可以根据个人喜好选择。
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .
                        connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(loggingInterceptor)
                .build()
                ;
       return new Retrofit.Builder()
                .baseUrl(NetUrl.BASEURL)
//                字符串
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .addConverterFactory(StringConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
//                .addConverterFactory(MyConverterFactory.create())//可以添加自定义解析器和默认的解析器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加响应式编程的适配器
                .client(okHttpClient)//添加自定义的OKHttpClient对象
                .build();


    }
}
