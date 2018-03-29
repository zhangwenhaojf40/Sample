package yy.hao.com.testphonemvp.net;

import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import yy.hao.com.testphonemvp.util.ToastUtils;

/**
 * Created by Administrator
 * on 2018/3/20 0020.
 */

public   abstract class BaseObserver<T> implements Observer<T>{
    @Override
    public void onSubscribe(Disposable d) {

    }






    @Override
    public void onError(Throwable e) {
        if(e instanceof  UnknownHostException)
        ToastUtils.showToast("没有网络");
    }

    @Override
    public void onComplete() {

    }
}
