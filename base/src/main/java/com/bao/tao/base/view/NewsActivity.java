package com.bao.tao.base.view;


import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.bao.tao.base.R;
import com.bao.tao.base.base.BaseActivity;
import com.bao.tao.base.iview.INewsActivity;
import com.bao.tao.base.present.NewsActivityPresent;
import com.bao.tao.base.view.fragment.NewsFragment;

import java.util.ArrayList;

import butterknife.BindView;


/**
 * Created by ZhangWenHao
 * on 2018/3/28 0028.
 */
public class NewsActivity extends BaseActivity<NewsActivityPresent> implements INewsActivity {


        ArrayList<String> titls = new ArrayList<>();



    TabLayout tabs;
    ViewPager viewPage;
    private ArrayList<Fragment> fragments;

    @Override
    protected void inject() {

    }

    @Override
    protected void initData() {

        initFragments();
        setTabViewpage();
    }

    @Override
    protected void initListenten() {

    }

    @Override
    protected void initView() {
        tabs = findViewById(R.id.tabs);
        viewPage = findViewById(R.id.view_page);
    }

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_news;
    }

    @Override
    public void setTabViewpage() {
        NewsPageAdapter newsPageAdapter = new NewsPageAdapter(getSupportFragmentManager());
        viewPage.setAdapter(newsPageAdapter);
        tabs.setupWithViewPager(viewPage);//将TabLayout和ViewPager关联起来。
        tabs.setTabsFromPagerAdapter(newsPageAdapter);//给Tabs设置适配器
    }

    @Override
    public void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(new NewsFragment());
        fragments.add(new NewsFragment());
        fragments.add(new NewsFragment());
        fragments.add(new NewsFragment());
        titls.add("新闻");
        titls.add("新闻");
        titls.add("新闻");
        titls.add("新闻");
        initTabLayout();

    }

    @Override
    public void initTabLayout() {
        tabs.addTab(tabs.newTab().setText(titls.get(0)));
        tabs.addTab(tabs.newTab().setText(titls.get(1)));
        tabs.addTab(tabs.newTab().setText(titls.get(2)));
    }

    class NewsPageAdapter extends FragmentPagerAdapter {
    public NewsPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titls.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
}
