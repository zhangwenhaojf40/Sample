package yy.hao.com.testphonemvp.view.design;

import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;

import butterknife.BindView;
import butterknife.OnClick;
import yy.hao.com.testphonemvp.R;
import yy.hao.com.testphonemvp.base.BaseActivity;

/**
 * Created by ZhangWenHao
 * on 2018/3/28 0028.
 */

public class CoordinatorLayoutActivity extends BaseActivity {
    @BindView(R.id.btn_float)
    Button btnFloat;

    @BindView(R.id.button3)
    Button button3;
    @BindView(R.id.button4)
    Button button4;

    @Override
    protected void inject() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListenten() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_coordinatorlayout;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @OnClick({R.id.btn_float, R.id.button3,R.id.button6, R.id.button4 ,R.id.button5})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_float:

                jumpActivity("/Activity/CoordActivityOneActivity");
                break;
            case R.id.button3:
                jumpActivity("/Activity/CoordActivityThreeActivity");
                break;
                case R.id.button4:
                jumpActivity("/Activity/TextInputActivity");
                break;
                case R.id.button5:
                jumpActivity("/Activity/CoordActivityFourActivity");
                break;
                case R.id.button6:
                jumpActivity("/Activity/CoordActivityFiveActivity");
                break;
        }
    }
}
