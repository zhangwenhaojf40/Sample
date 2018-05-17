package com.bao.tao.base.present;

import com.bao.tao.base.iview.INewsActivity;
import com.trello.rxlifecycle2.android.ActivityEvent;

import javax.inject.Inject;


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
