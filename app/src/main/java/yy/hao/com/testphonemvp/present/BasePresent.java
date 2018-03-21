package yy.hao.com.testphonemvp.present;

import android.net.IpPrefix;

import yy.hao.com.testphonemvp.base.IBaseView;

/**
 * Created by Administrator
 * on 2018/3/20 0020.
 */

public abstract class BasePresent<T extends IBaseView> implements IPresent<T>{
    public T mView;

    @Override
    public void attachView( T mView) {
        this.mView =  mView;
    }

    @Override
    public void detachView() {
        if (mView != null) {
            mView = null;
        }
    }
}
