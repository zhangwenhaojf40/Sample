package hao.wen.zhang.myview;

import android.view.View;
import android.widget.Button;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/14 0014 on 下午 6:10
 * 描述说明：
 */

public class SelfViewActivity extends BaseActivity implements View.OnClickListener {

    private Button btnBase;
    private Button btnBall;

    @Override
    protected void initData() {
        btnBase = (Button) findViewById(R.id.btn_wave);
        btnBall = (Button) findViewById(R.id.btn_ball);
        initListen();
    }
    private void initListen() {
        btnBase.setOnClickListener(this);
        btnBall.setOnClickListener(this);
    }

    @Override
    protected int getRes() {
        return R.layout.activity_self_view;
    }

    @Override
    public void onClick(View v) {
      /*  switch (v.getId()) {
            case R.id.btn_wave:
                jumpActivity(WaveActivity.class);
                break;
            case R.id.btn_ball:
                jumpActivity(BallActivity.class);
                break;
        }*/
        if (v.getId() == R.id.btn_ball) {
            jumpActivity(BallActivity.class);

        } else if (v.getId()==R.id.btn_wave) {
            jumpActivity(WaveActivity.class);
        }
    }
}
