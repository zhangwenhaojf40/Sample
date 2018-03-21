package yy.hao.com.testphonemvp.net;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import yy.hao.com.testphonemvp.m.LocationBean;

/**
 * Created by Administrator
 * on 2018/3/20 0020.
 */

public class NetManagerUtils{
    public static  ApiService Net() {
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
