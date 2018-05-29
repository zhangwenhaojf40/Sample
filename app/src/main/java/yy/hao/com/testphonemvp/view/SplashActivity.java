package yy.hao.com.testphonemvp.view;

import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bao.tao.base.RoutePath;
import com.bao.tao.base.base.BaseActivity;
import com.bao.tao.base.iview.ISplashActivity;
import com.bao.tao.base.util.Constru;
import com.bao.tao.base.util.PreferenceTool;

import java.util.concurrent.TimeUnit;

import hao.wen.zhang.guid.GuidActivity;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import yy.hao.com.testphonemvp.R;

/**
 * Created by ZhangWenHao
 * on 2018/3/27 0027.
 */
@Route(path= RoutePath.Splash)
public class SplashActivity extends BaseActivity implements ISplashActivity {
    ImageView ivLogContent;
    private boolean isFirst;

    @Override
    protected void inject() {

    }

    @Override
    protected void initData() {

        if(isFirst)
            return;
        Observable.timer(1500, TimeUnit.MILLISECONDS)
                .map(aLong-> true)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

                .subscribe(isBoolean->{
                    jumpMainActivity();
                });
    }

    @Override
    protected void initListenten() {

    }

    @Override
    protected void initView() {
        isFirst = PreferenceTool.getBoolean(Constru.ISFIRST, true);
        if (isFirst) {
           jumpActivityFinish(GuidActivity.class);
        } else {

            ivLogContent = findViewById(R.id.iv_log_content);
            initAnimal();
        }
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
        jumpActivityFinish(MainActivity.class);



    }


}
