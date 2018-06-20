package com.bao.tao.base.view;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

/**
 * 作者：ZWH
 * 创建日期： 2018/6/20 0020   下午 1:26
 * 描述说明：
 */

public class XuanFuService extends Service {
    public static boolean isStart = false;
    private final View.OnTouchListener listener = new View.OnTouchListener() {
        int  x;
        int  y;
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    x = (int) event.getRawX();
                    y = (int) event.getRawY();
                    break;
                case MotionEvent.ACTION_MOVE:
                    int nowX = (int) event.getRawX();
                    int nowY = (int) event.getRawY();
                    int movedX = nowX - x;
                    int movedY = nowY - y;
                    x = nowX;
                    y = nowY;
                    params.x = params.x + movedX;
                    params.y = params.y + movedY;
                    windowManager.updateViewLayout(v, params);
                    break;


            }

            return false;

        }
    };
    private WindowManager windowManager;
    private WindowManager.LayoutParams params;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;

    }

    @Override
    public void onCreate() {
        super.onCreate();
        windowManager = (WindowManager) getSystemService(WINDOW_SERVICE);
        params = new WindowManager.LayoutParams();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            params.type = WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY;
        } else {
            params.type = WindowManager.LayoutParams.TYPE_PHONE;
        }
        params.format = PixelFormat.RGBA_8888;
        params.gravity = Gravity.LEFT | Gravity.TOP;

        params.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
        params.x = 500;
        params.y = 500;
        params.height = 200;
        params.width = 500;


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        addBtn();
        return super.onStartCommand(intent, flags, startId);
    }

    private void addBtn() {
        isStart = true;
        Button btn = new Button(getApplicationContext());
        btn.setText("I am Button");
        btn.setOnTouchListener(listener);
        windowManager.addView(btn, params);
    }


}
