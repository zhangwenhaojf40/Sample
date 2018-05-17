package com.bao.tao.base.view.design;

import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.bao.tao.base.R;
import com.bao.tao.base.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by ZhangWenHao
 * on 2018/3/28 0028.
 */
public class CoordActivityFiveActivity extends BaseActivity {
    Toolbar toolBar;
    CollapsingToolbarLayout collapsingToolbar;
    AppBarLayout appBar;

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
        toolBar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolBar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(android.R.drawable.ic_input_delete);
        actionBar.setDisplayHomeAsUpEnabled(true);
        toolBar= findViewById(R.id.tool_bar);
        collapsingToolbar = findViewById(R.id.collapsing_toolbar);
        appBar = findViewById(R.id.app_bar);
        collapsingToolbar.setTitle("详情界面");
    }

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_coordfive;
    }


}
