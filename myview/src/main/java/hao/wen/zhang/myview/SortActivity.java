package hao.wen.zhang.myview;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bao.tao.base.CharacterParser;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/15 0015 on 上午 10:58
 * 描述说明：
 */

public class SortActivity extends BaseActivity {
    private String[] names = new String[]{"阿妹","打黑牛","张三","李四","王五","田鸡","孙五"};
    private RecyclerView mRecycleView;
    ArrayList<String> datas = new ArrayList<>();
    private CharacterParser parser;

    {

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
    }
    @Override
    protected void initData() {
        parser = CharacterParser.getInstance();
        mRecycleView = (RecyclerView) findViewById(R.id.rv_view);
        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mRecycleView.setAdapter(new SortAdapeter(R.layout.item_sort,datas));
    }

    @Override
    protected int getRes() {
        return R.layout.activity_sort;
    }

    class SortAdapeter extends BaseQuickAdapter<String, BaseViewHolder> {

        public SortAdapeter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            String convert = parser.getSelling(item);
            String sub=convert.substring(0, 1);

            helper.setText(R.id.tv, item)
                    .setText(R.id.english,sub.toUpperCase())
            ;
        }
    }
}
