package hao.wen.zhang.myview;

import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/21 0021 on 下午 5:59
 * 描述说明：
 */

public class TagActivity extends BaseActivity {
    //最大字符
    int Max = 7;
    ArrayList<String> datas = new ArrayList<>();
   Map<Integer,Boolean>map=new HashMap<>();
    {
        datas.add("我们等你1");
        datas.add("我们等你2");
        datas.add("我们等你3");
        datas.add("我们等你4");
        datas.add("阿斯顿发送到发送到发斯蒂芬");
        datas.add("我们等你5");
        datas.add("我们等你6");
        datas.add("反对党撒发放大打算范德萨");
        datas.add("生活不止眼前的苟且");
        datas.add("还有诗和远方的田野");
        datas.add("周杰伦");
        datas.add("许巍");
        datas.add("张杰");
        datas.add("谢娜");
    }
    @Override
    protected void initData() {
        RecyclerView mRecyclerView = findViewById(R.id.rv_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
               if(datas.get(position).length()>Max)
                   return 2;
               return 1;
            }
        });
        mRecyclerView.setLayoutManager(layoutManager);
        TagAdapeter tagAdapeter = new TagAdapeter();
        mRecyclerView.setAdapter(tagAdapeter);


    }

    @Override
    protected int getRes() {
        return R.layout.activity_tag;
    }

    class TagAdapeter extends RecyclerView.Adapter{

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = View.inflate(TagActivity.this, R.layout.tag_layout, null);
            return new MyHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

            final MyHolder myHolder = (MyHolder) holder;
            myHolder.tv.setText(datas.get(position));
            map.put(position, myHolder.tv.isSelected());

            myHolder.tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //得到该 索引是否选中  并改变
                    boolean isSelect = !map.get(position);
                    if (isSelect) {

                        myHolder.tv.setBackgroundResource(R.drawable.tag_select_bg);
                        myHolder.tv.setSelected(false);

                    } else {
                        myHolder.tv.setBackgroundResource(R.drawable.tag_normal_bg);
                        myHolder.tv.setSelected(true);
                    }
                    map.put(position, isSelect);
                }
            });
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }
        class MyHolder extends RecyclerView.ViewHolder{


            public TextView tv;


            public MyHolder(View itemView) {
                super(itemView);
               tv= itemView.findViewById(R.id.tag_tv);
            }
        }
    }
}
