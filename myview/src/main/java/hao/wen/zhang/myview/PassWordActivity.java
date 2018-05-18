package hao.wen.zhang.myview;

import com.bao.tao.base.util.ToastUtils;

import hao.wen.zhang.myview.view.PassWordView;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/18 0018 on 下午 1:42
 * 描述说明：
 */

public class PassWordActivity extends BaseActivity {

    private PassWordView mPassWordView;

    @Override
    protected void initData() {
        mPassWordView = findViewById(R.id.pwd);
        mPassWordView.setOnPassWordLisen(new PassWordView.OnPassWordListen() {
            @Override
            public void inputFinish(String pwd) {
                ToastUtils.showToast(pwd);
            }
        });
    }

    @Override
    protected int getRes() {
        return R.layout.activity_password;
    }
}
