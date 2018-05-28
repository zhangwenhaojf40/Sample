package hao.wen.zhang.chat;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bao.tao.base.base.IView;
import com.bao.tao.base.dagger2.compent.ApiCompent;
import com.bao.tao.base.m.ChatBean;
import com.bao.tao.base.util.ToastUtils;
import com.bao.tao.base.view.fragment.BaseFragment;

import java.util.ArrayList;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/28 0028   上午 10:38
 * 描述说明：
 */

public class ChatFragment extends BaseFragment implements IChatFragment {
    ChatFragmentPresent present;
    private RecyclerView mRecycleView;
    ArrayList<MsgBean> datas = new ArrayList<>();
    private Button mButtonSend;
    private EditText mEditText;
    private ChatAdapeter adapeter;

    {
        datas.add(new MsgBean(1, "你好啊"));
    }
    @Override
    protected void inject() {
        present=new ChatFragmentPresent(this);

    }

    @Override
    protected void initData() {
        mRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapeter = new ChatAdapeter();
        mRecycleView.setAdapter(adapeter);

    }

    @Override
    protected void initView(View view) {
        mButtonSend = view.findViewById(R.id.btn_send);
        mRecycleView = view.findViewById(R.id.rv_chat);
        mEditText = view.findViewById(R.id.et_msg);

        initListen();
    }

    private void initListen() {
        mButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = mEditText.getText().toString().trim();
                if (TextUtils.isEmpty(msg)) {
                    Toast.makeText(context, "消息不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                mEditText.setText("");
                datas.add(new MsgBean(2, msg));
                mRecycleView.smoothScrollToPosition(datas.size());
                adapeter.notifyItemInserted(datas.size());
                present.setMsg(msg);
                present.onCreate();
            }
        });
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_main;
    }
    public static Fragment newInstans() {

        return new ChatFragment();
    }

    @Override
    public void getData(ChatBean chatBean) {
        if (chatBean.code == 100000) {
            datas.add(new MsgBean(1, chatBean.text));
            adapeter.notifyDataSetChanged();
            mRecycleView.smoothScrollToPosition(datas.size());
        } else {
            ToastUtils.showToast("太累了，歇会吧");
        }
    }

    class ChatAdapeter extends RecyclerView.Adapter {

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            RecyclerView.ViewHolder holder;
            if (viewType == 1) {
                holder = new ChatLeftHolder(View.inflate(context,R.layout.turing_chat_left,null));

            } else  {
                holder = new ChatRightHolder(View.inflate(context,R.layout.turing_chat_right,null));
            }
            return holder;

        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            MsgBean msgBean = datas.get(position);
            if (msgBean.TYPE == 1) {
                ( (ChatLeftHolder)holder).mLeftTextView.setText(msgBean.msg);
            } else {
                ( (ChatRightHolder)holder).mRightTextView.setText(msgBean.msg);

            }
        }

        @Override
        public int getItemViewType(int position) {
            MsgBean msgBean = datas.get(position);
            return msgBean.TYPE;
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }
        class ChatLeftHolder extends RecyclerView.ViewHolder{
             TextView mLeftTextView;
             ChatLeftHolder(View itemView) {
                super(itemView);
                mLeftTextView    = itemView.findViewById(R.id.chat_text_left);
            }
        }
        class ChatRightHolder extends RecyclerView.ViewHolder{
            TextView mRightTextView;
             ChatRightHolder(View itemView) {
                super(itemView);
                mRightTextView=itemView.findViewById(R.id.chat_text_right);
            }
        }
    }
}
