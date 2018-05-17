package com.bao.tao.base.iview;


import com.bao.tao.base.base.IBaseView;
import com.bao.tao.base.m.ArtecleBean;

import java.util.List;

/**
 * Created by ZhangWenHao
 * on 2018/3/28 0028.
 */

public interface INewsFragment extends IBaseView {
    /*
    * 初始化适配器
    * */
    void initAdapter();

    /*
    * 获取数据
    * */
    void getNewsData(List<ArtecleBean.DataBean.DatasBean> list);
}
