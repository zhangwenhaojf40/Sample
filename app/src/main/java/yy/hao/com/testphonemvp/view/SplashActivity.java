package yy.hao.com.testphonemvp.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.alibaba.android.arouter.launcher.ARouter;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import yy.hao.com.testphonemvp.R;
import yy.hao.com.testphonemvp.base.BaseActivity;
import yy.hao.com.testphonemvp.iview.ISplashActivity;
import yy.hao.com.testphonemvp.present.SplashActivityPresent;

/**
 * Created by ZhangWenHao
 * on 2018/3/27 0027.
 */

public class SplashActivity extends BaseActivity<SplashActivityPresent> implements ISplashActivity {
    @BindView(R.id.iv_log_bg)
    ImageView ivLogBg;
    @BindView(R.id.iv_log_content)
    ImageView ivLogContent;

    @Override
    protected void inject() {
        mApiCompent.inject(this);
    }

    @Override
    protected void initData() {
        Observable.timer(1500, TimeUnit.MILLISECONDS)
                .map(new Function<Long, Boolean>() {

                    @Override
                    public Boolean apply(Long aLong) throws Exception {
                        return true;
                    }
                })
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        jumpMainActivity();
                    }
                });
    }

    @Override
    protected void initListenten() {

    }

    @Override
    protected void initView() {
        initAnimal();
    }

    private void initAnimal() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim_top_in);
        ivLogContent.startAnimation(animation);
    }

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_splash;
    }

    @Override
    public void jumpMainActivity() {

      /*  ARouter.getInstance().build("/Activity/MainActivity")
                .withTransition(android.R.anim.fade_in,android.R.anim.fade_out)
                .withString("aaa","bbb")
                .navigation();*/
        startActivity(new Intent(this,MainActivity.class));
//        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        finish();


    }


}
