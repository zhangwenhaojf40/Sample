package yy.hao.com.testphonemvp.present;

import com.trello.rxlifecycle2.android.ActivityEvent;

import javax.inject.Inject;

import yy.hao.com.testphonemvp.iview.INewsActivity;

/**
 * Created by ZhangWenHao
 * on 2018/3/28 0028.
 */

public class NewsActivityPresent extends BasePresent<INewsActivity,ActivityEvent> {
    @Inject
    public NewsActivityPresent() {
    }

    @Override
    public void onCreate() {

    }
}
