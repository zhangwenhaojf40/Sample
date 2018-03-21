package yy.hao.com.testphonemvp.net;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import yy.hao.com.testphonemvp.m.LocationBean;

/**
 * Created by Administrator
 * on 2018/3/20 0020.
 */

public interface ApiService {
    // 手机归属地查询          http://apis.juhe.cn/mobile/get?phone=18137700000&key=daf8fa858c330b22e342c882bcbac622
    @GET("mobile/get")
    Observable<LocationBean> getLocation(@Query("phone") String phoneNumber, @Query("key") String key);

}
