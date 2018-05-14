package hao.wen.zhang.myview;

import android.os.Bundle;
import android.support.annotation.Nullable;

import hao.wen.zhang.myview.view.WaveView;


/**
 * 作者：ZWH
 * 创建日期： 2018/5/14 0014 on 上午 10:30
 * 描述说明：
 */

public class WaveActivity extends BaseActivity {
    @Override
    protected int getRes() {
        return R.layout.activity_basel;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WaveView mBaselView = (WaveView) findViewById(R.id.baselview);
        mBaselView.startAnimation();

    }

    @Override
    protected void initData() {

    }
}
