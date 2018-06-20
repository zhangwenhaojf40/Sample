package com.bao.tao.base.view;

import android.app.Service;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.view.View;

import com.bao.tao.base.R;
import com.bao.tao.base.base.BaseActivity;

/**
 * 作者：ZWH
 * 创建日期： 2018/6/20 0020   下午 1:22
 * 描述说明：
 */

public class XuanFu extends BaseActivity {
    @Override
    protected void inject() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListenten() {

    }

    @Override
    protected void initView() {
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 23) {
                    if (!Settings.canDrawOverlays(XuanFu.this)) {
                        startActivityForResult(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:" + getPackageName())), 0);

                    } else {
                        startServices();
                    }
                } else {
                    startServices();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (Build.VERSION.SDK_INT >= 23) {

                if (Settings.canDrawOverlays(this)) {
                    startServices();
                }
            }
        }
    }

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_xuanfu;
    }
    public void startServices() {
        if(XuanFuService.isStart)
            return;
        startService(new Intent(this, XuanFuService.class));
    }
}
