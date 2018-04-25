package com.bao.tao.photo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Environment;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ZhangWenHao
 * on 2017/8/31 0031.
 */

public class BitmapUtils {
    static Context context;
    /*
    * 待优化
    * */
    public static void init(Context act) {
        context = act;
    }

    public static Bitmap imageZoom(Bitmap bitMap, double maxSize) {

        if (bitMap != null) {
            //将bitmap放至数组中，意在bitmap的大小（与实际读取的原文件要大）
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitMap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
            byte[] b = baos.toByteArray();
            //将字节换成KB
            double mid = b.length / 1024;
            //判断bitmap占用空间是否大于允许最大空间  如果大于则压缩 小于则不压缩
            if (mid > maxSize) {
                //获取bitmap大小 是允许最大大小的多少倍
                double i = mid / maxSize;
                //开始压缩  此处用到平方根 将宽带和高度压缩掉对应的平方根倍 （1.保持刻度和高度和原bitmap比率一致，压缩后也达到了最大大小占用空间的大小）
                bitMap = zoomImage(bitMap, bitMap.getWidth() / Math.sqrt(i),
                        bitMap.getHeight() / Math.sqrt(i));
            }
        }
        return bitMap;
    }

    /***
     * 图片的缩放方法
     *
     * @param bgimage   ：源图片资源
     * @param newWidth  ：缩放后宽度
     * @param newHeight ：缩放后高度
     * @return
     */
    public static Bitmap zoomImage(Bitmap bgimage, double newWidth,
                                   double newHeight) {
        // 获取这个图片的宽和高
        float width = bgimage.getWidth();
        float height = bgimage.getHeight();
        // 创建操作图片用的matrix对象
        Matrix matrix = new Matrix();
        // 计算宽高缩放率
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // 缩放图片动作
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap bitmap = Bitmap.createBitmap(bgimage, 0, 0, (int) width,
                (int) height, matrix, true);
        return bitmap;
    }

    /**
     * 压缩图片（质量压缩）
     * @param bitmap
     */
    public static File compressImage(Bitmap bitmap) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);//质量压缩方法，这里100表示不压缩，把压缩后的数据存放到baos中
        int options = 100;
        while (baos.toByteArray().length / 1024 > 500) {  //循环判断如果压缩后图片是否大于500kb,大于继续压缩
            baos.reset();//重置baos即清空baos
            options -= 10;//每次都减少10
            bitmap.compress(Bitmap.CompressFormat.JPEG, options, baos);//这里压缩options%，把压缩后的数据存放到baos中
            long length = baos.toByteArray().length;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date(System.currentTimeMillis());
        String filename = format.format(date);
        File file = new File(Environment.getExternalStorageDirectory(),filename+".png");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            try {
                fos.write(baos.toByteArray());
                fos.flush();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        recycleBitmap(bitmap);
        return file;
    }

    public  static void recycleBitmap(Bitmap bitmaps) {
        if( bitmaps != null && bitmaps.isRecycled()){
            bitmaps.recycle();
        }


    }


    public static Bitmap setPic(ImageView imageView, Uri uri) {

        //获取目标控件的大小d
        int targetW = imageView.getWidth();
        int targetH = imageView.getHeight();

        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        try {
            //inJustDecodeBounds为true，可以加载源图片的尺寸大小，decodeStream方法返回的bitmap为null
            bmOptions.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri), null, bmOptions);
            // 得到源图片的尺寸
            int photoW = bmOptions.outWidth;
            int photoH = bmOptions.outHeight;
            //通过比较获取较小的缩放比列
            int scaleFactor = Math.min(photoW / targetW, photoH / targetH);
            // 将inJustDecodeBounds置为false，设置bitmap的缩放比列
            bmOptions.inJustDecodeBounds = false;
            bmOptions.inSampleSize = scaleFactor;
            bmOptions.inPurgeable = true;
            //再次decode获取bitmap
            Bitmap bitmap = BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri), null, bmOptions);
            imageView.setImageBitmap(bitmap);

            return bitmap;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Bitmap showImageView(ImageView iv, Uri imageUri) {
        try {
            // 将拍摄的照片存储起来
            Bitmap bitmap = BitmapFactory.decodeStream(context.getContentResolver().openInputStream(imageUri));

            //压缩图片
            bitmap = BitmapUtils.imageZoom(bitmap, 310.00);


            if (bitmap == null) {
                //设置默认的图片
            } else {
                iv.setImageBitmap(bitmap);
            }
            return bitmap;

//                        setPicToView(bitmap);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Bitmap showImageViewPhoto(ImageView iv, Uri uri) {
        try {
            // 将拍摄的照片存储起来
            Bitmap bitmap = BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri));

            //压缩图片
            bitmap = BitmapUtils.imageZoom(bitmap, 310.00);


            if (bitmap == null) {
                //设置默认的图片
            } else {
                iv.setImageBitmap(bitmap);
            }
            return bitmap;

//                        setPicToView(bitmap);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    //保存图片
  /*  private void setPicToView(Bitmap mBitmap) {
        FileOutputStream b = null;
        String profilePicFileWholePath = path + picFileName;// 图片完整路径
        File outputImage = new File(profilePicFileWholePath);//使用了与之前保存拍照图片一样的文件保存裁剪后的图片，可以用不同文件将完整图片和剪裁后的都保存下来
        try {
            if (outputImage.exists()) {
                outputImage.delete();
            }
            outputImage.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            b = new FileOutputStream(profilePicFileWholePath);
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件 100表示压缩率为
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭流
                b.flush();
                b.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/


    /**
     * 调用系统的裁剪功能
     */
   /* public void cropPhoto(Uri uri, int requestCode) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image*//*");
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.addFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
        intent.putExtra("crop", "true");// crop = true是设置在开启的Intent中设置显示的VIEW可裁剪
        intent.putExtra("aspectX", 1); // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 200);// outputX outputY 是裁剪图片宽高
        intent.putExtra("outputY", 100);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, requestCode);
    }*/

}
