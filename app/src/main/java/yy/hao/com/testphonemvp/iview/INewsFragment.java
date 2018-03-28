package yy.hao.com.testphonemvp.iview;

import java.util.ArrayList;
import java.util.List;

import yy.hao.com.testphonemvp.base.IBaseView;
import yy.hao.com.testphonemvp.m.ArtecleBean;

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
