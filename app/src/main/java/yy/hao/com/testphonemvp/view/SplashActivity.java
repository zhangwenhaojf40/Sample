package yy.hao.com.testphonemvp.view;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bao.tao.base.base.BaseActivity;
import com.bao.tao.base.iview.ISplashActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
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
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        Log.e("Splash", "accept:== "+Thread.currentThread().getName() );
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
//        startActivity(new Intent(this,MainActivity.class));
//        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


        finish();


    }


}
