package com.bao.tao.base.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bao.tao.base.R;
import com.bao.tao.base.base.BaseActivity;
import com.bao.tao.base.iview.IPhoneActivity;
import com.bao.tao.base.m.Result;
import com.bao.tao.base.present.PhoneActivityPresent;
import com.bao.tao.base.util.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator
 * on 2018/3/20 0020.
 */

public class PhoneActivity extends BaseActivity<PhoneActivityPresent> implements IPhoneActivity<Result>, View.OnClickListener {

    EditText etPhone;
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
        btnQuery.setOnClickListener(this);
    }

    @Override
    protected void initView() {
        etPhone = findViewById(R.id.et_phone);
        btnQuery = findViewById(R.id.btn_query);
        btnQuery.setText(mPresent.toString());
    }

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_phone;
    }






    @Override
    public void setText(String aaa) {
        btnQuery.setText(aaa);
    }


    @Override
    public void getData(Result mData) {
        ToastUtils.showToast(mData.province+mData.city);
    }

    @Override
    public void onClick(View v) {
        mPhoneNumber = etPhone.getText().toString().trim();
        if (TextUtils.isEmpty(mPhoneNumber)) {
            ToastUtils.showToast("不能为空");
            return;
        }
        mPresent.build()
                .setPhoneNumber(mPhoneNumber);
        mPresent.onCreate();
    }
}
