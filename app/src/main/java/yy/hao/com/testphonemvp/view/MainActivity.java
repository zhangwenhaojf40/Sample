package yy.hao.com.testphonemvp.view;

import android.content.Intent;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;
import yy.hao.com.testphonemvp.R;
import yy.hao.com.testphonemvp.base.BaseActivity;
import yy.hao.com.testphonemvp.iview.IMainAcitvity;
import yy.hao.com.testphonemvp.present.MainActivityPresent;

public class MainActivity extends BaseActivity<MainActivityPresent>implements IMainAcitvity {

    @BindView(R.id.btn_jump)
    Button btnJump;


    @Override
    protected void inject() {
        mApiCompent.inject(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListenten() {

    }

    @Override
    protected void initView() {
        btnJump.setText(mPresent.toString());
    }

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_main;
    }

    @OnClick(R.id.btn_jump)
    public void onViewClicked() {
        jumpToPhoneActivity();

    }

    @Override
    public void jumpToPhoneActivity() {
        startActivity(new Intent(this,PhoneActivity.class));
    }
}
