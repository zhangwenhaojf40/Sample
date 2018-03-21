package yy.hao.com.testphonemvp.present;

import yy.hao.com.testphonemvp.base.IBaseView;

/**
 * Created by Administrator
 * on 2018/3/20 0020.
 */

public interface IPresent<T extends IBaseView> {
    void onCreate();

    void attachView(T mView);

    void detachView();
}
