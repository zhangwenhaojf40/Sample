package hao.wen.zhang.myview;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/14 0014 on 上午 10:30
 * 描述说明：
 */

public abstract class BaseActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getRes());
        initData();

    }

    protected abstract void initData();

    public void jumpActivity(Class <? extends AppCompatActivity> clz) {
        Intent intent = new Intent(this,clz);
        startActivity(intent);



    }
    protected abstract int getRes();
}
