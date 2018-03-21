package yy.hao.com.testphonemvp.util;

import android.view.Gravity;
import android.widget.Toast;

import javax.inject.Inject;

import yy.hao.com.testphonemvp.app.MyApp;

/**
 * Created by ZhangWenHao on 2017/11/22 0022.
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
