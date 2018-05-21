package hao.wen.zhang.myview;

import android.view.View;

import hao.wen.zhang.myview.view.MyTextView;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/21 0021 on 上午 10:40
 * 描述说明：
 */

public class MyViewActivity extends BaseActivity {

    private MyTextView myTextView;

    @Override
    protected void initData() {
        myTextView = findViewById(R.id.my_view);
        myTextView.setTextContent("我们都是好孩子，奥德赛发送到发送到发送到发送到发送到发斯蒂芬阿斯蒂芬阿斯蒂芬阿斯蒂芬");
    }

    @Override
    protected int getRes() {
        return R.layout.activity_myview;
    }
}
