package yy.hao.com.testphonemvp.m;

import javax.inject.Inject;

import yy.hao.com.testphonemvp.util.ToastUtils;

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
