package hao.wen.zhang.myview;

import android.view.View;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/21 0021 on 下午 4:33
 * 描述说明：
 */

public class GoodLuckActivity extends BaseActivity{

    @Override
    protected void initData() {
        findViewById(R.id.iv_luck).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    protected int getRes() {
        return R.layout.activity_goodluck;
    }
}
