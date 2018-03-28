package yy.hao.com.testphonemvp.view.design;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.alibaba.android.arouter.facade.annotation.Route;

import butterknife.BindView;
import butterknife.ButterKnife;
import yy.hao.com.testphonemvp.R;
import yy.hao.com.testphonemvp.base.BaseActivity;

/**
 * Created by ZhangWenHao
 * on 2018/3/28 0028.
 */
@Route(path = "/Activity/CoordActivityFiveActivity")
public class CoordActivityFiveActivity extends BaseActivity {
    @BindView(R.id.tool_bar)
    Toolbar toolBar;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.app_bar)
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
        setSupportActionBar(toolBar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(android.R.drawable.ic_input_delete);
        actionBar.setDisplayHomeAsUpEnabled(true);

        collapsingToolbar.setTitle("详情界面");
    }

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_coordfive;
    }


}
