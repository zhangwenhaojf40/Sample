package hao.wen.zhang.myview;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bao.tao.base.CharacterParser;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

import hao.wen.zhang.myview.view.SortView;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/15 0015 on 上午 10:58
 * 描述说明：
 */

public class SortActivity extends BaseActivity {
    private RecyclerView mRecycleView;
    ArrayList<String> datas = new ArrayList<>();
    private CharacterParser parser;

    /*
    * 所有的字母添加入集合中
    * */
    ArrayList<String> letters = new ArrayList<>();
    private SortView mSortView;

    public void setData() {

        datas.add("阿妹");
        datas.add("阿妹");
        datas.add("阿妹");
        datas.add("阿妹");
        datas.add("阿妹");
        datas.add("阿妹");
        datas.add("打黑牛");
        datas.add("打黑牛");
        datas.add("打黑牛");
        datas.add("李四");
        datas.add("李四");
        datas.add("李四");
        datas.add("王五");
        datas.add("王五");
        datas.add("王五");
        datas.add("田鸡");
        datas.add("田鸡");
        datas.add("孙五");
        datas.add("孙五");
        datas.add("孙五");
        datas.add("孙五");
        datas.add("孙五");

        //汉字首字母  加入集合中
        for(int i=0;i<datas.size();i++) {
            //汉字转字母
            String convert = parser.getSelling(datas.get(i));
            //截取第一个字母 并转大写
            String letter = convert.substring(0, 1).toUpperCase();

            letters.add(letter);


        }
    }
    @Override
    protected void initData() {
        parser = CharacterParser.getInstance();
        //添加数据
        setData();


        mRecycleView = (RecyclerView) findViewById(R.id.rv_view);
        mSortView = (SortView) findViewById(R.id.sort_view);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecycleView.setLayoutManager(layoutManager);
        mRecycleView.setAdapter(new SortAdapeter(R.layout.item_sort,datas));
        findViewById(R.id.btn_sroll).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutManager.scrollToPositionWithOffset(6,0);
            }
        });
        mSortView.setTouchAbc(new SortView.TouchABC() {
            @Override
            public void touchABC(String abc) {
                Toast.makeText(SortActivity.this, abc, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected int getRes() {
        return R.layout.activity_sort;
    }
    class SortAdapeter extends BaseQuickAdapter<String, BaseViewHolder> {

        public SortAdapeter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }
        /*
        * 上一个字母
        * */

        @Override
        protected void convert(BaseViewHolder helper, String item) {

            int position = helper.getPosition();
            /*
            * 如果postion==0    显示分割线
            * 否则 postion-1   对比
            * */

            helper.setText(R.id.tv, item);
            if (position == 0) {
                helper.setText(R.id.english, letters.get(position));
                helper.setVisible(R.id.english, true);
            } else {//当前  和上一个   对比
                //上一个首字母
                String preLetter = letters.get(position-1);
                String letter = letters.get(position);
                if (preLetter.equals(letter)) {//相等   不显示
                    helper.setVisible(R.id.english, false);
                } else { //不相等   显示

                    helper.setText(R.id.english, letter);
                    helper.setVisible(R.id.english, true);

                }
            }


        }
    }
}
