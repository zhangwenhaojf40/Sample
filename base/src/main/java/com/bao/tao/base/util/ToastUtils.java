package com.bao.tao.base.util;

import android.view.Gravity;
import android.widget.Toast;

import com.bao.tao.base.app.MyApp;


/**
 * Created by ZhangWenHao
 * on 2017/11/22 0022.
 */

public class ToastUtils {

    static Toast sToast ;

    public static void showToast(String msg) {


        if (sToast == null) {
            sToast = Toast.makeText(MyApp.getApp(), msg, Toast.LENGTH_SHORT);
        } else {
            sToast.setText(msg);
        }
        sToast.setGravity(Gravity.CENTER, 0, 0);
        sToast.show();


    }
}
