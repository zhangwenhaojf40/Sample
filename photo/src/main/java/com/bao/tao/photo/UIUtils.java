package com.bao.tao.photo;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;



/**
 * Created by Administrator on 2017/3/2 0002.
 */
public class UIUtils {
    /**
     * activity跳转
     *
     * @param intent
     */
    public static void startActivity(Intent intent) {

            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);// 指定任务栈
            getContext().startActivity(intent);

    }
    public static Context getContext() {
        return null;
    }

    public static View getView(Context context, int layoutRes) {
        return View.inflate(context, layoutRes, null);
    }


    /***
     * 从父view 中移除当前view对象
     * @param view
     */
    public static void removeFromParent(View view){
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent != null && parent instanceof ViewGroup) {
                ViewGroup group = (ViewGroup) parent;
                // loadingpage 从父view 中移除  断绝关系
                group.removeView(view);
            }
        }
    }

}
