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
    private Button btnWatch;
    private Button btnSort;
    private Button btnRader;
    private Button btnTouchBall;
    private Button btnProgress;
    private Button btnTestOne;
    private Button btnShader;
    private Button btnPassWord;
    private Button btnText;
    private Button btnSport;
    private Button btnLuck;
    private Button btnTag;
    @Override
    protected void initData() {
        btnBase = (Button) findViewById(R.id.btn_wave);
        btnBall = (Button) findViewById(R.id.btn_ball);
        btnWatch = (Button) findViewById(R.id.btn_watch);
        btnSort = (Button) findViewById(R.id.btn_sort);
        btnRader = (Button) findViewById(R.id.btn_rader);
        btnTouchBall = (Button) findViewById(R.id.btn_touch_ball);
        btnProgress = (Button) findViewById(R.id.btn_progress);
        btnTestOne = (Button) findViewById(R.id.btn_test_one);
        btnShader = (Button) findViewById(R.id.btn_test_shader);
        btnPassWord = (Button) findViewById(R.id.btn_password);
        btnText = (Button) findViewById(R.id.btn_text);
        btnSport = (Button) findViewById(R.id.btn_sport);
        btnLuck = (Button) findViewById(R.id.btn_luck);
        btnTag = (Button) findViewById(R.id.btn_tag);
        initListen();
    }
    private void initListen() {
        btnBase.setOnClickListener(this);
        btnBall.setOnClickListener(this);
        btnWatch.setOnClickListener(this);
        btnSort.setOnClickListener(this);
        btnRader.setOnClickListener(this);
        btnTouchBall.setOnClickListener(this);
        btnProgress.setOnClickListener(this);
        btnTestOne.setOnClickListener(this);
        btnShader.setOnClickListener(this);
        btnPassWord.setOnClickListener(this);
        btnText.setOnClickListener(this);
        btnSport.setOnClickListener(this);
        btnLuck.setOnClickListener(this);
        btnTag.setOnClickListener(this);
    }

    @Override
    protected int getRes() {
        return R.layout.activity_self_view;
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();

        if (id == R.id.btn_ball) {
            jumpActivity(BallActivity.class);

        } else if (id==R.id.btn_wave) {
            jumpActivity(WaveActivity.class);
        }else if (id==R.id.btn_watch) {
            jumpActivity(WatchActivity.class);
        }else if (id==R.id.btn_sort) {
            jumpActivity(SortActivity.class);
        }else if (id==R.id.btn_rader) {
            jumpActivity(RaderActivity.class);
        }else if (id==R.id.btn_touch_ball) {
            jumpActivity(TouchBallActivity.class);
        }else if (id==R.id.btn_progress) {
            jumpActivity(PregressActivity.class);
        }else if (id==R.id.btn_test_one) {
            jumpActivity(TestViewActivity.class);
        }else if (id==R.id.btn_test_shader) {
            jumpActivity(ShaderActivity.class);
        }else if (id==R.id.btn_password) {
            jumpActivity(PassWordActivity.class);
        }else if (id==R.id.btn_text) {
            jumpActivity(MyViewActivity.class);
        }else if (id==R.id.btn_sport) {
            jumpActivity(SportActivity.class);
        }else if (id==R.id.btn_luck) {
            jumpActivity(GoodLuckActivity.class);
        }else if (id==R.id.btn_tag) {
            jumpActivity(TagActivity.class);
        }
    }
}
