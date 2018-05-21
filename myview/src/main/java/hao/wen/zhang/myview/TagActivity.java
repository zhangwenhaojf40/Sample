package hao.wen.zhang.myview;

import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/21 0021 on 下午 5:59
 * 描述说明：
 */

public class TagActivity extends BaseActivity {
    ArrayList<String> datas = new ArrayList<>();
    {
        datas.add("我们等你");
        datas.add("我们等你");
        datas.add("我们等你");
        datas.add("我们等你");
        datas.add("我们等你");
        datas.add("我们等你");
        datas.add("我们等你");
        datas.add("我们等你");
        datas.add("我们等你");
    }
    @Override
    protected void initData() {
        RecyclerView mRecyclerView = findViewById(R.id.rv_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        mRecyclerView.setAdapter(new TagAdapeter(R.layout.tag_layout,datas));
    }

    @Override
    protected int getRes() {
        return R.layout.activity_tag;
    }

    class TagAdapeter extends BaseQuickAdapter<String, BaseViewHolder> {

        public TagAdapeter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(BaseViewHolder helper, String item) {
            helper.setText(R.id.tag_tv, item);
        }
    }
}
