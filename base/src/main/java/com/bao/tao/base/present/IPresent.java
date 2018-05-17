package com.bao.tao.base.present;

import com.bao.tao.base.base.IBaseView;
import com.trello.rxlifecycle2.LifecycleProvider;


/**
 * Created by Administrator
 * on 2018/3/20 0020.
 */

public interface IPresent<iview extends IBaseView,T> {
    void onCreate();

    void attachView(iview mView, LifecycleProvider<T> provider);

    void detachView();
}
