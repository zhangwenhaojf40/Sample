package com.bao.tao.base.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bao.tao.base.R;
import com.bao.tao.base.adapter.NewsAdapter;
import com.bao.tao.base.iview.INewsFragment;
import com.bao.tao.base.m.ArtecleBean;
import com.bao.tao.base.present.NewsFragmentPresent;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by ZhangWenHao
 * on 2018/3/28 0028.
 */

public class NewsFragment extends BaseFragment<NewsFragmentPresent> implements INewsFragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Inject
    NewsAdapter newsAdapter;

    RecyclerView rvNews;



    @Override
    protected void inject() {
        mApiCompent.inject(this);
    }

    @Override
    protected void initData() {
        initAdapter();
        mPresenter.onCreate();
    }

    @Override
    protected void initView(View view) {
        rvNews = view.findViewById(R.id.rv_news);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_news;
    }


    @Override
    public void initAdapter() {
        rvNews.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvNews.setAdapter(newsAdapter);
    }

    @Override
    public void getNewsData(List<ArtecleBean.DataBean.DatasBean> list) {
        newsAdapter.setNewData(list);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
