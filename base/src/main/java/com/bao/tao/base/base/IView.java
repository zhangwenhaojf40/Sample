package com.bao.tao.base.base;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/28 0028   下午 3:50
 * 描述说明：
 */

public interface IView<T> extends IBaseView {
    void getData(T t);
}
