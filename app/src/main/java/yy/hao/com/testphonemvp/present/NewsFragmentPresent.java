package yy.hao.com.testphonemvp.present;

import com.trello.rxlifecycle2.android.FragmentEvent;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.http.Body;
import yy.hao.com.testphonemvp.iview.INewsFragment;
import yy.hao.com.testphonemvp.m.ArtecleBean;
import yy.hao.com.testphonemvp.net.ApiService;
import yy.hao.com.testphonemvp.net.BaseObserver;
import yy.hao.com.testphonemvp.util.ToastUtils;

/**
 * Created by ZhangWenHao
 * on 2018/3/28 0028.
 */

public class NewsFragmentPresent extends BasePresent<INewsFragment,FragmentEvent> {
    private ApiService api;

    @Inject
    public NewsFragmentPresent(ApiService api) {

        this.api = api;
    }

    @Override
    public void onCreate() {
        api.getArtecle()

                .subscribeOn(Schedulers.newThread())
                .compose(provider.bindToLifecycle())

                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<ArtecleBean>() {
                    @Override
                    public void onNext(ArtecleBean artecleBean) {
                        if (artecleBean.getErrorCode() == 0) {
                        mView.getNewsData(artecleBean.getData().getDatas());
                        } else {
                            ToastUtils.showToast(artecleBean.getErrorMsg());
                        }
                    }
                });
    }
}
