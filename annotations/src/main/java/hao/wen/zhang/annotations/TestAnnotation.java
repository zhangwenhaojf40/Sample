package hao.wen.zhang.annotations;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import hao.wen.zhang.annotations.bind.Bind;
import hao.wen.zhang.annotations.bind.BindClick;
import hao.wen.zhang.annotations.bind.BindRes;
import hao.wen.zhang.annotations.set.Person;
import hao.wen.zhang.annotations.set.PersonAnno;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/29 0029   下午 2:51
 * 描述说明：
 */
@BindRes(R.layout.activity_test)
public class TestAnnotation extends AppCompatActivity {
    @Bind(R.id.tv)
    TextView mTextView;
    @Bind(R.id.tv_person)
    TextView pTextView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Inject.inJect(this);
        mTextView.setText("zhang");
    }
    @BindClick(R.id.tv)
    public void onClick(View view) {
        if (view.getId() == R.id.tv) {
            Toast.makeText(this, "点击", Toast.LENGTH_SHORT).show();
        }
    }
}
