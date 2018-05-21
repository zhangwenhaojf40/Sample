package hao.wen.zhang.myview;

import android.view.View;

import hao.wen.zhang.myview.view.SportView;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/21 0021 on 下午 2:05
 * 描述说明：
 */

public class SportActivity extends BaseActivity {
    @Override
    protected void initData() {
        SportView sportView = findViewById(R.id.sport);
        sportView.setProgress(8000);
    }

    @Override
    protected int getRes() {
        return R.layout.activity_sport;
    }
}
