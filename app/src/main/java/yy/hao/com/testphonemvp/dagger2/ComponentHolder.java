package yy.hao.com.testphonemvp.dagger2;

import yy.hao.com.testphonemvp.dagger2.compent.AppCompent;

/**
 * Created by Administrator
 * on 2018/3/20 0020.
 */

public class ComponentHolder {
    static AppCompent mAppCompent;
    public static void setAppCompent(AppCompent appCompent) {
        mAppCompent = appCompent;
    }
    public static AppCompent getAppCompent() {
        return mAppCompent;
    }
}
