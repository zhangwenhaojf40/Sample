package hao.wen.zhang.guid;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bao.tao.base.base.BaseActivity;
import com.bao.tao.base.util.Constru;
import com.bao.tao.base.util.PreferenceTool;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/25 0025   上午 11:11
 * 描述说明：
 */

public class GuidActivity  extends BaseActivity implements View.OnClickListener {
    boolean isFirst;
    private int current;
    private ViewPager mViewPage;
    private int[] bgColors;
    private ImageView[] ivColors;

    private ImageButton mImageButtonPre;
    private ImageButton mImageButtonNext;
    private ImageView mImageViewOne;
    private ImageView mImageViewTwo;
    private ImageView mImageViewThree;
    private Button mButton;

    @Override
    protected void inject() {

    }

    @Override
    protected void initData() {
        mViewPage.setAdapter(new GuidApapter(getSupportFragmentManager()));
        mViewPage.setBackgroundColor(bgColors[0]);

    }

    @Override
    protected void initListenten() {
        mImageButtonNext.setOnClickListener(this);
        mImageButtonPre.setOnClickListener(this);
        mButton.setOnClickListener(this);
        mViewPage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int evaluate = (int) new ArgbEvaluator().evaluate(positionOffset, bgColors[position], bgColors[position==2?position:position + 1]);
                mViewPage.setBackgroundColor(evaluate);

            }

            @Override
            public void onPageSelected(int position) {
                current = position;
                mViewPage.setBackgroundColor(bgColors[position]);
                //箭头
                changArrow(position);
                //知识点颜色
                changPointBg(position);
                if (position == 2) {
                    mButton.setVisibility(View.VISIBLE);
                } else {
                    mButton.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void changPointBg(int position) {

        for(int i =0;i<ivColors.length;i++) {
            if (i == position) {
                ivColors[i].setImageResource(R.drawable.circle_select);

            } else {
                ivColors[i].setImageResource(R.drawable.circle_unselect);

            }
        }
    }

    /*
    * 箭头显示 隐藏
    * */
    private void changArrow(int position) {
        if (position ==0) {
            mImageButtonPre.setVisibility(View.GONE);
            mImageButtonNext.setVisibility(View.VISIBLE);
        } else if (position == 1) {
            mImageButtonPre.setVisibility(View.VISIBLE);
            mImageButtonNext.setVisibility(View.VISIBLE);
        } else if (position == 2) {
            mImageButtonPre.setVisibility(View.VISIBLE);
            mImageButtonNext.setVisibility(View.GONE);
        }

    }

    @Override
    protected void initView() {


        mButton = findViewById(R.id.btn_into);
        mViewPage = findViewById(R.id.vp_content);
        mImageButtonPre = findViewById(R.id.ib_point_pre);
        mImageButtonNext = findViewById(R.id.ib_point_next);
        mImageViewOne = findViewById(R.id.iv_one);
        mImageViewTwo = findViewById(R.id.iv_two);
        mImageViewThree = findViewById(R.id.iv_three);
        //背景颜色
        initBgColor();
        //指示点
        initImage();


    }

    private void initImage() {
        ivColors = new ImageView[]{mImageViewOne, mImageViewTwo, mImageViewThree};
    }

    private void initBgColor() {
        bgColors = new int[]{ContextCompat.getColor(this, R.color.Primary),
                 ContextCompat.getColor(this, R.color.cyan_500),
                 ContextCompat.getColor(this, R.color.light_blue_500)};
        ;
    }

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_guid;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.ib_point_next) {
            mViewPage.setCurrentItem(current==2?current:current+1);
        } else if (id == R.id.ib_point_pre) {
            mViewPage.setCurrentItem(current==0?current:current-1);
        } else if (id == R.id.btn_into) {
            PreferenceTool.putBoolean(Constru.ISFIRST,false);
            PreferenceTool.commit();
            Intent intent = new Intent();
            intent.setAction("MainActivity");
            startActivity(intent);
            finish();

        }
    }

    class GuidApapter extends FragmentPagerAdapter {

        public GuidApapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return GuidFragment.newInstans(position);
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
