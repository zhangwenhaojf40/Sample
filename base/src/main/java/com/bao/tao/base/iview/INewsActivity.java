package com.bao.tao.base.iview;


import com.bao.tao.base.base.IBaseView;

/**
 * Created by ZhangWenHao
 * on 2018/3/28 0028.
 */

public interface INewsActivity extends IBaseView {
    /*
    * 关联TabLayout  联动
    * */
    void setTabViewpage();

    /*
    * 创建 fragment数组
    * */
    void initFragments();
    /*
    * 初始化  TabLayout
    * */
    void initTabLayout();
}
