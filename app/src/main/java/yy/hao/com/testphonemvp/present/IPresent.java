package yy.hao.com.testphonemvp.present;

import com.trello.rxlifecycle2.LifecycleProvider;

import yy.hao.com.testphonemvp.base.IBaseView;

/**
 * Created by Administrator
 * on 2018/3/20 0020.
 */

public interface IPresent<iview extends IBaseView,T> {
    void onCreate();

    void attachView(iview mView,LifecycleProvider<T> provider);

    void detachView();
}
