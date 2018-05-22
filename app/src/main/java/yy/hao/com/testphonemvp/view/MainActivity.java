package yy.hao.com.testphonemvp.view;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bao.tao.base.base.BaseActivity;
import com.bao.tao.base.iview.IMainAcitvity;
import com.bao.tao.base.m.Student;
import com.bao.tao.base.view.NewsActivity;
import com.bao.tao.base.view.PhoneActivity;
import com.bao.tao.base.view.ShareElementActivity;
import com.bao.tao.base.view.design.CoordinatorLayoutActivity;
import com.bao.tao.photo.ImageActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


import hao.wen.zhang.myview.SelfViewActivity;
import hao.wen.zhang.sharelib.ShareActivity;
import yy.hao.com.testphonemvp.R;


public class MainActivity extends BaseActivity implements IMainAcitvity {






    RecyclerView mRecycleView;
    ArrayList<String> demos = new ArrayList<>();
    ArrayList<Class<? extends AppCompatActivity>>activities=new ArrayList<>();
    private ImageView ivLog;

    {

        demos.add("新特性");
        demos.add("新闻列表");
        demos.add("图库");

        demos.add("自定义View");
        demos.add("分享");


    }
    {
        activities.add(CoordinatorLayoutActivity.class);
        activities.add(NewsActivity.class);
        activities.add(ImageActivity.class);


        activities.add(SelfViewActivity.class);
        activities.add(ShareActivity.class);


    }
    @Override
    protected void inject() {
    }

    @Override
    protected void initData() {
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        MainAdapeter adapeter = new MainAdapeter(R.layout.item_main, demos);
        mRecycleView.setAdapter(adapeter);
        adapeter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                jumpActivity(activities.get(position));
            }
        });

    }



    @Override
    protected void initListenten() {
        ivLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ShareElementActivity.class);
                if (Build.VERSION.SDK_INT > 21) {

                    ActivityOptionsCompat optionsCompat =
                            ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, ivLog, "transitionImg");
                    ActivityCompat.startActivity(MainActivity.this, intent, optionsCompat.toBundle());

                } else {
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void initView() {
        ivLog = findViewById(R.id.iv_log);
        mRecycleView = findViewById(R.id.rv_main);
    }

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_main;
    }


    @Override
    public void jumpToPhoneActivity() {
        startActivity(new Intent(this, PhoneActivity.class));
    }


    class MainAdapeter extends BaseQuickAdapter<String, BaseViewHolder> {

        public MainAdapeter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_name, item);
        }
    }
}
