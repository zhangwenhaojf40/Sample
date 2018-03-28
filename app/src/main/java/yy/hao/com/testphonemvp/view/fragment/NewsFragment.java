package yy.hao.com.testphonemvp.view.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import yy.hao.com.testphonemvp.R;
import yy.hao.com.testphonemvp.adapter.NewsAdapter;
import yy.hao.com.testphonemvp.iview.INewsFragment;
import yy.hao.com.testphonemvp.m.ArtecleBean;
import yy.hao.com.testphonemvp.present.NewsFragmentPresent;

/**
 * Created by ZhangWenHao
 * on 2018/3/28 0028.
 */

public class NewsFragment extends BaseFragment<NewsFragmentPresent> implements INewsFragment {
    @Inject
    NewsAdapter newsAdapter;
    @BindView(R.id.rv_news)
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


}
