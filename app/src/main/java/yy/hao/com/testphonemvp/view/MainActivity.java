package yy.hao.com.testphonemvp.view;

import android.content.Intent;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import yy.hao.com.testphonemvp.R;
import yy.hao.com.testphonemvp.animation.BindValues;
import yy.hao.com.testphonemvp.base.BaseActivity;
import yy.hao.com.testphonemvp.iview.IMainAcitvity;
import yy.hao.com.testphonemvp.m.Student;
import yy.hao.com.testphonemvp.present.MainActivityPresent;
@Route(path = "/Activity/MainActivity")
public class MainActivity extends BaseActivity<MainActivityPresent>implements IMainAcitvity {

    @BindView(R.id.btn_jump)
    Button btnJump;

    @Inject
    Student student;


    @Override
    protected void inject() {
       mApiCompent.inject(this);
    }

    @Override
    protected void initData() {
        getClass().isAnnotationPresent(BindValues.class);
        BindValues annotation = getClass().getAnnotation(BindValues.class);
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
