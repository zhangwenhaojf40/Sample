package com.bao.tao.photo;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

import me.iwf.photopicker.PhotoPicker;

public class ImageActivity extends AppCompatActivity implements View.OnClickListener {
    //申请权限
    public static final int CARM = 1;
    public static final int IMAGE = 2;
    //请求码
    public static final int CARMREQUEST = 1000;
    public static final int IMAGEREQUEST = 2000;

    private  File path;//图片保存目录
    private String picFileName = "one.jpg";//营业执照
    //是否需要动态申请权限
    boolean M;
    private File file1;
    private ImageView mImageView;
    private ImgUtil imgUtils;
    private String TAG="aaa";
    private Uri imageUri;//图片路径Uri
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        /*
        *
        * 此处待优化*/
        BitmapUtils.init(this);
        //相机
        findViewById(R.id.btn_carm).setOnClickListener(this);
        //相册
        findViewById(R.id.btn_photo).setOnClickListener(this);
        mImageView = findViewById(R.id.iv);
        //调用三方库
        findViewById(R.id.btn_other).setOnClickListener(this);
        //是否需要动态申请权限
        M = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M;
        imgUtils = new ImgUtil();
    }

    @Override
    public void onClick(View v) {

        int i = v.getId();
        if (i == R.id.btn_carm) {
            if (M) {//需要申请
                chekPermissCarm();
            }

        } else if (i == R.id.btn_photo) {
            if (M) {//需要申请
                chekPermissImage();
            }

        } else if (i == R.id.btn_other) {
            PhotoPicker.builder()
                    .setPhotoCount(9)
                    .setShowCamera(true)
                    .setShowGif(true)
                    .setPreviewEnabled(false)
                    .start(this, PhotoPicker.REQUEST_CODE);

        }
    }
    /*
       * 申请相机权限
       * */
    private void chekPermissCarm() {
        //检查有无权限
        if (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(ImageActivity.this, Manifest.permission.CAMERA)) {
            openCarm();
        } else {
            ActivityCompat.requestPermissions(ImageActivity.this,
                    new String[]{Manifest.permission.CAMERA},
                    CARM);
        }
    }
    /*
  * 申请相册
  * */
    private void chekPermissImage() {
        //检查有无权限
        if (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(ImageActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)) {

            openImage();
        } else {
            ActivityCompat.requestPermissions(ImageActivity.this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    IMAGE);
        }
    }

    /*
    * 调用相册
    * */
    private void openImage() {

        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        startActivityForResult(intent, IMAGEREQUEST);
    }
    /*
   * 权限申请回调
   * */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == CARM) {//相机
            // 跳转到系统照相机
            openCarm();
        } else if (requestCode == IMAGE) {//相册
            openImage();
        } else {
            Toast.makeText(ImageActivity.this, "需要打开权限", Toast.LENGTH_SHORT).show();
        }
    }
    /*
    * 调用相机
    * */
    public void openCarm() {
        /*
        * 这种方式也可以   onActivityResult中
        *
        *
        *  Bundle bundle = data.getExtras();
                Bitmap bitmap1 = (Bitmap) bundle.get("data");
                Log.e(TAG, "onActivityResult: "+bitmap1.getByteCount() );
                mImageView.setImageBitmap(bitmap1);
                直接获取即可    但是是经过系统压缩的  不清楚

        * */
      /*  Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(intent, CARMREQUEST);*/

        initFile();//定义用户存储拍摄图片的文件
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(intent, CARMREQUEST);//拍摄成功后将跳转至onActivityResult
    }
    /*
      * 结果回调
      * */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CARMREQUEST:


                    Bitmap bitmap = BitmapUtils.setPic(mImageView, imageUri);
                    Log.e(TAG, "onActivityResult: "+ bitmap.getByteCount()+"================");
                    if (bitmap != null) {
                        //上次服务器的文件
                        file1 = BitmapUtils.compressImage(bitmap);
                    }
                    setClearBitmp(bitmap);



                break;
            case IMAGEREQUEST:
                Bitmap bitmap1 = null;
                //判断手机系统版本号
                if (Build.VERSION.SDK_INT >= 19) {
                    //4.4及以上系统使用这个方法处理图片
                    bitmap1 =imgUtils .handleImageOnKitKat(this, data,mImageView);    //ImgUtil是自己实现的一个工具类

                } else {
                    //4.4以下系统使用这个方法处理图片
                    bitmap1 = imgUtils.handleImageBeforeKitKat(this, data);
                }

                mImageView.setImageBitmap(bitmap1);

                break;
        }



    }
    /*
    * bitmap  制空
    * */
    private void setClearBitmp(Bitmap bitmap) {
        if (bitmap != null && bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }
    //创建文件并获取其路径的Uri
    private void initFile() {
        // 创建File对象，用于存储拍照后生成的图片
        path = getExternalCacheDir();
        File outputImage = new File(path + picFileName);//使用应用关联缓存目录存放图片
        try {
            if (outputImage.exists()) {
                outputImage.delete();
            }
            outputImage.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (Build.VERSION.SDK_INT < 24) {
            //7.0之前，
            imageUri = Uri.fromFile(outputImage);
        } else {
            //7.0之后
            imageUri = FileProvider.getUriForFile(this, BuildConfig.APPLICATION_ID + ".fileProvider", outputImage);
        }
    }

}
