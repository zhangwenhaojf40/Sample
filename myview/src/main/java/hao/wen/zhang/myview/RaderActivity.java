package hao.wen.zhang.myview;

import hao.wen.zhang.myview.view.RaderView;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/15 0015 on 上午 11:08
 * 描述说明：
 */

public class RaderActivity extends BaseActivity {

    private RaderView raderView;

    @Override
    protected void initData() {
        raderView = (RaderView) findViewById(R.id.rader);
        raderView.startAnimation();
    }

    @Override
    protected int getRes() {
        return R.layout.activity_rader;
    }
}
