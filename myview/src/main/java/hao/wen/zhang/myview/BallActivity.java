package hao.wen.zhang.myview;


import hao.wen.zhang.myview.view.BallView;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/14 0014 on 下午 1:33
 * 描述说明：
 */

public class BallActivity extends BaseActivity{


    @Override
    protected int getRes() {
        return R.layout.activity_sample;
    }



    @Override
    protected void initData() {
        BallView sampleView = findViewById(R.id.sample);
        sampleView.startAnimal();
    }
}
