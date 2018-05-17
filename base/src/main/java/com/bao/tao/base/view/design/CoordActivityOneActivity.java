package com.bao.tao.base.view.design;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import com.bao.tao.base.R;
import com.bao.tao.base.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ZhangWenHao
 * on 2018/3/28 0028.
 */
public class CoordActivityOneActivity extends BaseActivity implements View.OnClickListener {
    private FloatingActionButton faBtn;


    @Override
    protected void inject() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListenten() {
        findViewById(R.id.faBtn).setOnClickListener(this);
    }

    @Override
    protected void initView() {
        faBtn = findViewById(R.id.faBtn);
    }


    @Override
    protected int setLayoutResource() {
        return R.layout.activity_coordone;
    }





    @Override
    public void onClick(View v) {
        Snackbar snackbar = Snackbar.make(faBtn, "Snackbar", Snackbar.LENGTH_LONG)
                .setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //TODO
                    }
                });
        //设置提示文字颜色
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();
        ((TextView) snackbarLayout.findViewById(R.id.snackbar_text)).setTextColor(Color.parseColor("#FFFFFF"));
        snackbar.show();
    }
}
