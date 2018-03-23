package yy.hao.com.testphonemvp.present;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import yy.hao.com.testphonemvp.iview.IPhoneActivity;
import yy.hao.com.testphonemvp.m.LocationBean;
import yy.hao.com.testphonemvp.m.Result;
import yy.hao.com.testphonemvp.net.ApiService;
import yy.hao.com.testphonemvp.net.BaseObserver;
import yy.hao.com.testphonemvp.net.NetUtils;

/**
 * Created by Administrator
 * on 2018/3/20 0020.
 */

public class PhoneActivityPresent extends BasePresent<IPhoneActivity<Result>> {

    ApiService api;

    String mPhoneNumber;
    @Inject
    public PhoneActivityPresent(ApiService api) {

        this.api = api;



    }

    @Override
    public void onCreate() {
        api.getLocation(mPhoneNumber, NetUtils.KEY)
        .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<LocationBean>() {
                    @Override
                    public void onNext(LocationBean locationBean) {
                        if ("200".equals(locationBean.resultcode)) {
                            mView.getData(locationBean.result);

                        }
                    }
                });
    }
    public PhoneActivityPresent build() {
        return this;
    }
   public void setPhoneNumber(String mPhoneNumber) {
    this.mPhoneNumber = mPhoneNumber;
}

}
