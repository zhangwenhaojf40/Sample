package com.bao.tao.base.view.design;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bao.tao.base.R;
import com.bao.tao.base.base.BaseActivity;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by ZhangWenHao
 * on 2018/3/28 0028.
 */
public class CoordActivityFourActivity extends BaseActivity {

    ArrayList <String >data;
    private RecyclerView mRecycleView;

    @Override
    protected void inject() {

    }

    @Override
    protected void initData() {
        data = new ArrayList<>();
        for (int i = 'A'; i <= 'Z'; i++) {
            data.add("" + (char) i);
        }

        mRecycleView.setLayoutManager(new LinearLayoutManager(this));
        mRecycleView.setAdapter(new ListAdapter());
        mRecycleView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @Override
    protected void initListenten() {

    }

    @Override
    protected void initView() {
        mRecycleView = findViewById(R.id.recycler_view);
    }

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_coordtwo;
    }



    class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

        @Override
        public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ListViewHolder holder = new ListViewHolder(
                    View.inflate(CoordActivityFourActivity.this, R.layout.adapter_list, null));

            return holder;
        }

        @Override
        public void onBindViewHolder(ListViewHolder holder, int position) {
            holder.tv_number.setText(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class ListViewHolder extends RecyclerView.ViewHolder {
            TextView tv_number;

            public ListViewHolder(View view) {
                super(view);
                tv_number = (TextView) view.findViewById(R.id.tv_number);
            }
        }
    }
}
