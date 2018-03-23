package yy.hao.com.testphonemvp.view;

import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.OnClick;
import yy.hao.com.testphonemvp.R;
import yy.hao.com.testphonemvp.base.BaseActivity;
import yy.hao.com.testphonemvp.iview.IPhoneActivity;
import yy.hao.com.testphonemvp.m.Result;
import yy.hao.com.testphonemvp.present.PhoneActivityPresent;
import yy.hao.com.testphonemvp.util.ToastUtils;

/**
 * Created by Administrator
 * on 2018/3/20 0020.
 */

public class PhoneActivity extends BaseActivity<PhoneActivityPresent> implements IPhoneActivity<Result> {

    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.btn_query)
    Button btnQuery;
    private String mPhoneNumber;
    public String  aaa="33333";

    @Override
    protected void inject() {
     mApiCompent.inject(this);

    }

    @Override
    protected void initData() {
        mPresent.onCreate();
    }

    @Override
    protected void initListenten() {

    }

    @Override
    protected void initView() {
        btnQuery.setText(mPresent.toString());
    }

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_phone;
    }



    @OnClick(R.id.btn_query)
    public void onViewClicked() {
        mPhoneNumber = etPhone.getText().toString().trim();
        if (TextUtils.isEmpty(mPhoneNumber)) {
            ToastUtils.showToast("不能为空");
            return;
        }
        mPresent.build()
                .setPhoneNumber(mPhoneNumber);
        mPresent.onCreate();
    }



    @Override
    public void setText(String aaa) {
        btnQuery.setText(aaa);
    }


    @Override
    public void getData(Result mData) {
        ToastUtils.showToast(mData.province+mData.city);
    }
}
