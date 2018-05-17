package hao.wen.zhang.sharelib;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/17 0017 on 下午 5:30
 * 描述说明：
 */

public class ShareActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        //初始化友盟
        UMShareAPI.get(this);
        PlatformConfig.setWeixin("wx6c609010c5101349", "c896637e1b9e97756f3ca156b64f7aa1");
        PlatformConfig.setQQZone("1106718190", "8EEZLoo4oBLmfZkL");
        findViewById(R.id.btn_share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //开启权限
                openPremiss();
            }
        });
    }
    private void openPremiss() {
        if(Build.VERSION.SDK_INT>=23){
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.ACCESS_FINE_LOCATION,Manifest.permission.CALL_PHONE,Manifest.permission.READ_LOGS,Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.SET_DEBUG_APP,Manifest.permission.SYSTEM_ALERT_WINDOW,Manifest.permission.GET_ACCOUNTS,Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this,mPermissionList,123);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        if (requestCode == 123) {
            new ShareAction(ShareActivity.this).withText("hello").setDisplayList(SHARE_MEDIA.SINA, SHARE_MEDIA.QQ, SHARE_MEDIA.WEIXIN)
                    .setCallback(new UMShareListener() {
                        @Override
                        public void onStart(SHARE_MEDIA share_media) {

                        }

                        @Override
                        public void onResult(SHARE_MEDIA share_media) {
                            System.out.println(share_media.toString());
                        }

                        @Override
                        public void onError(SHARE_MEDIA share_media, Throwable throwable) {
                            System.out.println(throwable.getMessage());
                        }

                        @Override
                        public void onCancel(SHARE_MEDIA share_media) {

                        }
                    }).open();
        } else {
            Toast.makeText(this, "权限拒绝，不能使用", Toast.LENGTH_SHORT).show();
        }
    }
}
