package yy.hao.com.testphonemvp.view.design;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;

import butterknife.BindView;
import butterknife.OnClick;
import yy.hao.com.testphonemvp.R;
import yy.hao.com.testphonemvp.base.BaseActivity;

/**
 * Created by ZhangWenHao
 * on 2018/3/28 0028.
 */
@Route(path = "/Activity/CoordActivityOneActivity")
public class CoordActivityOneActivity extends BaseActivity {
    @BindView(R.id.faBtn)
    FloatingActionButton faBtn;

    @Override
    protected void inject() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListenten() {

    }

    @Override
    protected void initView() {

    }


    @Override
    protected int setLayoutResource() {
        return R.layout.activity_coordone;
    }



    @OnClick(R.id.faBtn)
    public void onViewClicked() {
        Snackbar snackbar = Snackbar.make(faBtn, "Snackbar", Snackbar.LENGTH_LONG)
                .setAction("确定", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //TODO
                    }
                });
        //设置提示文字颜色
        Snackbar.SnackbarLayout snackbarLayout = (Snackbar.SnackbarLayout) snackbar.getView();
        ((TextView) snackbarLayout.findViewById(R.id.snackbar_text)).setTextColor(Color.parseColor("#FFFFFF"));
        snackbar.show();
    }
}
