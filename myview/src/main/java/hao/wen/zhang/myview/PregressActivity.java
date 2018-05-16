package hao.wen.zhang.myview;

import hao.wen.zhang.myview.view.LinearProgressView;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/16 0016 on 下午 5:14
 * 描述说明：
 */

public class PregressActivity extends BaseActivity {

    private LinearProgressView lineProgress;

    @Override
    protected void initData() {
        lineProgress = (LinearProgressView) findViewById(R.id.progress);
        lineProgress.startAnimation();

    }


    @Override
    protected int getRes() {
        return R.layout.activity_progress;
    }
}
