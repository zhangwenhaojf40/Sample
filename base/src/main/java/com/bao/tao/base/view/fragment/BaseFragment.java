package com.bao.tao.base.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bao.tao.base.base.IBaseView;
import com.bao.tao.base.dagger2.ComponentHolder;
import com.bao.tao.base.dagger2.compent.ApiCompent;
import com.bao.tao.base.dagger2.compent.DaggerApiCompent;
import com.bao.tao.base.dagger2.module.ActivityModule;
import com.bao.tao.base.dagger2.module.ApiModule;
import com.bao.tao.base.present.BasePresent;
import com.trello.rxlifecycle2.components.support.RxFragment;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.Unbinder;



/**
 * Created by ZhangWenHao
 * on 2017/11/16 0016.
 */

public abstract  class BaseFragment<T extends BasePresent> extends RxFragment implements IBaseView {
    @Inject
    public T mPresenter;
    public Context context;
    public ApiCompent mApiCompent;
    Unbinder unbinder;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inject();
        attachView();
        if(this.context == null) {
            this.context = this.getActivity();
        }
        if(view==null)
        view = View.inflate(this.context, this.getLayoutResId(),  null);
        unbinder = ButterKnife.bind(this, view);
        initView(view);

        initData();
        return view;
    }

    private void attachView() {
        if (mPresenter != null) {
            mPresenter.attachView(this,this);
        }
    }
    /**
     * 分离view
     */
    private void detachView() {
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }


    protected abstract void inject();

    protected abstract void initData();

    protected abstract void initView(View view);

    protected abstract int getLayoutResId();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApiCompent=  DaggerApiCompent.builder().apiModule(new ApiModule())
                .appCompent(ComponentHolder.getAppCompent())
                .activityModule(new ActivityModule())
                .build();
    }






    @Override
    public void onDestroy() {
        super.onDestroy();
        detachView();
        unbinder.unbind();
    }
}
