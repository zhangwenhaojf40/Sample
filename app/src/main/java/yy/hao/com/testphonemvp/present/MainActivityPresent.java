package yy.hao.com.testphonemvp.present;

import android.app.Activity;

import com.trello.rxlifecycle2.android.ActivityEvent;

import javax.inject.Inject;

import yy.hao.com.testphonemvp.iview.IMainAcitvity;
import yy.hao.com.testphonemvp.m.Student;
import yy.hao.com.testphonemvp.view.MainActivity;

/**
 * Created by Administrator
 * on 2018/3/20 0020.
 */

public class MainActivityPresent extends BasePresent<IMainAcitvity,ActivityEvent> {

    @Inject
    public MainActivityPresent() {

    }

    @Override
    public void onCreate() {

    }


}
