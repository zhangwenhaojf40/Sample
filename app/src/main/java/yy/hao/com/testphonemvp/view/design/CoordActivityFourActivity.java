package yy.hao.com.testphonemvp.view.design;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import yy.hao.com.testphonemvp.R;
import yy.hao.com.testphonemvp.base.BaseActivity;

/**
 * Created by ZhangWenHao
 * on 2018/3/28 0028.
 */
@Route(path = "/Activity/CoordActivityFourActivity")
public class CoordActivityFourActivity extends BaseActivity {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    ArrayList <String >data;
    @Override
    protected void inject() {

    }

    @Override
    protected void initData() {
        data = new ArrayList<>();
        for (int i = 'A'; i <= 'Z'; i++) {
            data.add("" + (char) i);
        }

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ListAdapter());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    @Override
    protected void initListenten() {

    }

    @Override
    protected void initView() {

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
