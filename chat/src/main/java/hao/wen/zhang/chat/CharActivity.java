package hao.wen.zhang.chat;


import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.bao.tao.base.base.BaseActivity;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/25 0025   下午 5:21
 * 描述说明：
 */

public class CharActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar mToolBar;
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    @Override
    protected void inject() {

    }

    @Override
    protected void initData() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction trans = fm.beginTransaction();
        trans.add(R.id.fl_content, ChatFragment.newInstans()).commit();
    }

    @Override
    protected void initListenten() {
        mNavigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void initView() {
        mToolBar = findViewById(R.id.tool_bar);
        mNavigationView = findViewById(R.id.nv_view);
        setSupportActionBar(mToolBar);
        mDrawerLayout = findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar, R.string.app_name, R.string.app_name);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();


    }

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_chat;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_setting) {
            Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show();
        } else if (id==R.id.menu_about) {
            Toast.makeText(this, "关于", Toast.LENGTH_SHORT).show();

        }
        return false;
    }
}
