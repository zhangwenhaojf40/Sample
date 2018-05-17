package com.bao.tao.base.present;

import com.bao.tao.base.iview.INewsFragment;
import com.bao.tao.base.m.ArtecleBean;
import com.bao.tao.base.net.ApiService;
import com.bao.tao.base.net.BaseObserver;
import com.bao.tao.base.util.ToastUtils;
import com.trello.rxlifecycle2.android.FragmentEvent;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ZhangWenHao
 * on 2018/3/28 0028.
 */

public class NewsFragmentPresent extends BasePresent<INewsFragment,FragmentEvent> {
    private ApiService api;

    @Inject
    public NewsFragmentPresent(ApiService api) {

        this.api = api;
    }

    @Override
    public void onCreate() {
        api.getArtecle()

                .subscribeOn(Schedulers.newThread())
                .compose(provider.<ArtecleBean>bindToLifecycle())

                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<ArtecleBean>() {
                    @Override
                    public void onNext(ArtecleBean artecleBean) {
                        if (artecleBean.getErrorCode() == 0) {
                        mView.getNewsData(artecleBean.getData().getDatas());
                        } else {
                            ToastUtils.showToast(artecleBean.getErrorMsg());
                        }
                    }
                }

                       );
    }

}
