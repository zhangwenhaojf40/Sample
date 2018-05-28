package hao.wen.zhang.chat;

import com.bao.tao.base.http.RetroftUtil;
import com.bao.tao.base.m.ChatBean;
import com.bao.tao.base.net.ApiService;
import com.bao.tao.base.net.BaseObserver;
import com.bao.tao.base.present.BasePresent;
import com.bao.tao.base.util.Constru;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/28 0028   下午 3:05
 * 描述说明：
 */

public class ChatFragmentPresent extends BasePresent<IChatFragment,ChatBean> {
    private IChatFragment mView;

    public ChatFragmentPresent(IChatFragment mView) {
        this.mView = mView;

    }

    private String msg;

    @Override
    public void onCreate() {
        RetroftUtil.newInstans().provideApi().getResponse(Constru.KEY, msg)
                .subscribeOn(Schedulers.io())

                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver<com.bao.tao.base.m.ChatBean>() {
                    @Override
                    public void onNext(com.bao.tao.base.m.ChatBean chatBean) {
                        mView.getData(chatBean);
                    }
                });

    }

    public void setMsg(String msg) {

        this.msg = msg;
    }
}
