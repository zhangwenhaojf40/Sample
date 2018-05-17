package com.bao.tao.base.present;

import com.bao.tao.base.iview.IPhoneActivity;
import com.bao.tao.base.m.LocationBean;
import com.bao.tao.base.m.Result;
import com.bao.tao.base.net.ApiService;
import com.bao.tao.base.net.BaseObserver;
import com.bao.tao.base.net.NetUtils;
import com.trello.rxlifecycle2.android.ActivityEvent;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator
 * on 2018/3/20 0020.
 */

public class PhoneActivityPresent extends BasePresent<IPhoneActivity<Result>,ActivityEvent> {

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
