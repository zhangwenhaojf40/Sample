package com.bao.tao.base.adapter;

import android.text.Html;

import com.bao.tao.base.R;
import com.bao.tao.base.m.ArtecleBean;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;


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