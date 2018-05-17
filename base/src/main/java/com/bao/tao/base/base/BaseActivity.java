package com.bao.tao.base.base;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.bao.tao.base.dagger2.ComponentHolder;
import com.bao.tao.base.dagger2.compent.ApiCompent;
import com.bao.tao.base.dagger2.compent.DaggerApiCompent;
import com.bao.tao.base.dagger2.module.ActivityModule;
import com.bao.tao.base.dagger2.module.ApiModule;
import com.bao.tao.base.present.IPresent;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;



/**
 * Created by Administrator
 * on 2018/3/20 0020.
 */

public abstract  class BaseActivity<T extends IPresent> extends RxAppCompatActivity implements IBaseView {
    @Inject
    public T mPresent;
    public ApiCompent mApiCompent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        setTranslucentStatus();
        mApiCompent=  DaggerApiCompent.builder().apiModule(new ApiModule())
                .appCompent(ComponentHolder.getAppCompent())
                .activityModule(new ActivityModule())
                .build();

        inject();
        attachView();
        super.onCreate(savedInstanceState);
        setContentView(setLayoutResource());
        ButterKnife.bind(this);
        initView();

        initListenten();
        initData();
    }



    private void attachView() {
        if (mPresent != null) {
            mPresent.attachView(this,this);
        }
    }
    private void detachView() {
        if (mPresent != null) {
            mPresent.detachView();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        detachView();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        return super.onMenuOpened(featureId, menu);
    }
    protected abstract void inject();

    protected abstract void initData();

    protected abstract void initListenten();

    protected abstract void initView();

    protected abstract int setLayoutResource();
    protected void setTranslucentStatus() {
        // 5.0以上系统状态栏透明
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            //如果是首页  则需要判断状态栏字体能否改变  如不能改变 半透明

                window.setStatusBarColor(Color.parseColor("#55000000"));

        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    public void jumpActivity(Class<? extends AppCompatActivity> clz) {
       startActivity(new Intent(this,clz));
    }

}
