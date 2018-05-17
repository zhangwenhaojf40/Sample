package com.bao.tao.base.m;

import com.bao.tao.base.util.ToastUtils;

import javax.inject.Inject;


/**
 * Created by Administrator
 * on 2018/3/21 0021.
 */

public class Car {
    @Inject
    public Car() {
        ToastUtils.showToast("我是小汽车");
    }
}
