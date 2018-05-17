package com.bao.tao.base.net;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;

/**
 * Created by ZhangWenHao
 * on 2018/3/28 0028.
 */

public class ProgressTransformer<T> implements ObservableTransformer<T, T> {
    private Observable<T> observable;

    public ProgressTransformer(Observable<T> observable) {
        this.observable = observable;
    }

    @Override
    public ObservableSource<T> apply(Observable<T> upstream) {
        return upstream.takeUntil(observable);
    }
}
