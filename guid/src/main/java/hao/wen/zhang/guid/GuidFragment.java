package hao.wen.zhang.guid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bao.tao.base.view.fragment.BaseFragment;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/25 0025   上午 11:49
 * 描述说明：
 */

public class GuidFragment extends BaseFragment
{

    public static final String  BUNDLE_KEY = "position";
    private TextView mTextView;
    /*
    * 背景颜色
    * */
    private int position;
    /*
    * 文字描述
    * */
    String[] desc = new String[]{"黑夜无论怎样悠长，白昼总会到来","一个人思虑太多，就会失去做人的乐趣",
    "生存还是毁灭，这是个问题"
    };
    private ImageView mImageView;
    int[] ivLogs = new int[]{R.drawable.ic_fragment_one,R.drawable.ic_fragment_two, R.drawable.ic_fragment_three};


    @Override
    protected void inject() {

    }

    @Override
    protected void initData() {
        //改变图片
        mImageView.setImageResource(ivLogs[position]);
        mTextView.setText(desc[position]);
    }



    @Override
    protected void initView(View view) {
        mImageView = view.findViewById(R.id.iv_log);
        mTextView = view.findViewById(R.id.tv_desc);

        Bundle bundle = getArguments();
        if (bundle != null) {

          position =    bundle.getInt(BUNDLE_KEY);
        }


    }



    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_guid;
    }
    public static Fragment newInstans(int position) {

        GuidFragment mGuidFragment = new GuidFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(BUNDLE_KEY, position);
        mGuidFragment.setArguments(bundle);
        return mGuidFragment;
    }
}
