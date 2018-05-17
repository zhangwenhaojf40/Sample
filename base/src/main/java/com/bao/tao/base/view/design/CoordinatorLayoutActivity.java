package com.bao.tao.base.view.design;

import android.view.View;
import android.widget.Button;

import com.bao.tao.base.R;
import com.bao.tao.base.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by ZhangWenHao
 * on 2018/3/28 0028.
 */

public class CoordinatorLayoutActivity extends BaseActivity implements View.OnClickListener {
    Button btnFloat;

    Button button3;

    Button button4;
    Button button5;
    Button button6;

    @Override
    protected void inject() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListenten() {
        btnFloat.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        btnFloat = findViewById(R.id.btn_float);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
    }

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_coordinatorlayout;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }




    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id==R.id.btn_float) {
            jumpActivity(CoordActivityOneActivity.class);
        } else if (id == R.id.button3) {
            jumpActivity(CoordActivityThreeActivity.class);
        } else if (id == R.id.button4) {
            jumpActivity(TextInputActivity.class);
        }else if (id == R.id.button5) {
            jumpActivity(CoordActivityFourActivity.class);
        }else if (id == R.id.button6) {
            jumpActivity(CoordActivityFiveActivity.class);
        }
    }
}
