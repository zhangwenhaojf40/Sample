package yy.hao.com.testphonemvp.view;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.bao.tao.photo.ImageActivity;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import hao.wen.zhang.myview.SelfViewActivity;
import yy.hao.com.testphonemvp.R;
import yy.hao.com.testphonemvp.base.BaseActivity;
import yy.hao.com.testphonemvp.iview.IMainAcitvity;
import yy.hao.com.testphonemvp.m.Student;
import yy.hao.com.testphonemvp.present.MainActivityPresent;
import yy.hao.com.testphonemvp.view.design.CoordinatorLayoutActivity;


public class MainActivity extends BaseActivity<MainActivityPresent> implements IMainAcitvity {



    @Inject
    Student student;

    @BindView(R.id.rv_main)
    RecyclerView mRecycleView;
    ArrayList<String> demos = new ArrayList<>();
    ArrayList<Class<? extends AppCompatActivity>>activities=new ArrayList<>();

    {

        demos.add("新特性");
        demos.add("新闻列表");
        demos.add("图库");

        demos.add("自定义View");

    }
    {
        activities.add(CoordinatorLayoutActivity.class);
        activities.add(NewsActivity.class);
        activities.add(ImageActivity.class);


        activities.add(SelfViewActivity.class);


    }
    @Override
    protected void inject() {
        mApiCompent.inject(this);
    }

    @Override
    protected void initData() {
        Log.e("ee", "initData: "+"************" );
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
