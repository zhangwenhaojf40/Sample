package com.bao.tao.base.iview;


import com.bao.tao.base.base.IBaseView;

/**
 * Created by Administrator
 * on 2018/3/20 0020.
 */

public interface IPhoneActivity<T> extends IBaseView {


    void setText(String aaa);

    void getData(T mData);

}
