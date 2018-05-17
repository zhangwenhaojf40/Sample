package yy.hao.com.testphonemvp.view;

import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bao.tao.base.base.BaseActivity;
import com.bao.tao.base.iview.ISplashActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import yy.hao.com.testphonemvp.R;

/**
 * Created by ZhangWenHao
 * on 2018/3/27 0027.
 */

public class SplashActivity extends BaseActivity implements ISplashActivity {
    ImageView ivLogContent;

    @Override
    protected void inject() {
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
        ivLogContent = findViewById(R.id.iv_log_content);
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
