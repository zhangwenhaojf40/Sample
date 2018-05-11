package yy.hao.com.testphonemvp.util;

import android.content.Context;

import yy.hao.com.testphonemvp.app.MyApp;

/**
 * Created by ZhangWenHao on 2017/12/13 0013.
 */

public class DpUtils {
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px( float dpValue) {
        final float scale = MyApp.getApp().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale+0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip( float pxValue) {
        final float scale = MyApp.getApp().getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }


}
