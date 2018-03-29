package yy.hao.com.testphonemvp.view;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import yy.hao.com.testphonemvp.R;
import yy.hao.com.testphonemvp.animation.BindValues;
import yy.hao.com.testphonemvp.base.BaseActivity;
import yy.hao.com.testphonemvp.iview.IMainAcitvity;
import yy.hao.com.testphonemvp.m.Student;
import yy.hao.com.testphonemvp.present.MainActivityPresent;
import yy.hao.com.testphonemvp.view.design.CoordinatorLayoutActivity;


public class MainActivity extends BaseActivity<MainActivityPresent> implements IMainAcitvity {

    @BindView(R.id.btn_jump)
    Button btnJump;

    @Inject
    Student student;
    @BindView(R.id.btn_new_list)
    Button btnNewList;


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

    }

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_main;
    }


    @Override
    public void jumpToPhoneActivity() {
        startActivity(new Intent(this, PhoneActivity.class));
    }


    @OnClick({R.id.btn_jump, R.id.btn_new_list})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_jump:
//                jumpActivity("/Activity/CoordinatorLayoutActivity");
                startActivity(new Intent(this,CoordinatorLayoutActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                break;
            case R.id.btn_new_list:
                jumpActivity("/Activity/NewsActivity");
                break;
        }
    }
}
