package yy.hao.com.testphonemvp.adapter;

import android.support.annotation.Nullable;
import android.text.Html;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import yy.hao.com.testphonemvp.R;
import yy.hao.com.testphonemvp.m.ArtecleBean;

public class NewsAdapter extends BaseQuickAdapter<ArtecleBean.DataBean.DatasBean,BaseViewHolder> {


        public NewsAdapter(int layoutResId) {
            super(layoutResId);
        }

        @Override
        protected void convert(BaseViewHolder helper, ArtecleBean.DataBean.DatasBean item) {
            helper.setText(R.id.tvAuthor, item.getAuthor());
            helper.setText(R.id.tvNiceDate, item.getNiceDate());
            helper.setText(R.id.tvTitle, Html.fromHtml(item.getTitle()));
            helper.setText(R.id.tvChapterName, item.getChapterName());

        }
    }