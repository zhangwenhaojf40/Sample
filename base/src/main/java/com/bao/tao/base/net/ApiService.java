package com.bao.tao.base.net;

import com.bao.tao.base.m.ArtecleBean;
import com.bao.tao.base.m.ChatBean;
import com.bao.tao.base.m.LocationBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Administrator
 * on 2018/3/20 0020.
 */

public interface ApiService {
    // 手机归属地查询          http://apis.juhe.cn/mobile/get?phone=18137700000&key=daf8fa858c330b22e342c882bcbac622
    @GET("mobile/get")
    Observable<LocationBean> getLocation(@Query("phone") String phoneNumber, @Query("key") String key);
    @GET("article/list/1/json")
    Observable<ArtecleBean> getArtecle();

    @POST("openapi/api")
    Observable<ChatBean> getResponse(@Query("key") String key, @Query("info") String info);

}
