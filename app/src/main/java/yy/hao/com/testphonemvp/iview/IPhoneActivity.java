package yy.hao.com.testphonemvp.iview;

import yy.hao.com.testphonemvp.base.IBaseView;

/**
 * Created by Administrator
 * on 2018/3/20 0020.
 */

public interface IPhoneActivity<T> extends IBaseView {
    void getPhoneNumber();



    void getData(T mData);

}
