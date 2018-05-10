package yy.hao.com.testphonemvp.selfview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/10 0010 on 下午 4:42
 * 描述说明：
 */

public class BiaoView extends View {

    private final Paint paint;
    private int min;
    private int width;
    private int height;

    public BiaoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.WHITE);

    }
    /*
    * 距离X 的距离
    * */
    int difX=0;
    /*
    * 线的长度
    * */
    int lineWith = 50;

    int moveX=0;
    int moveY=0;
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        width = getMeasuredWidth();
        height = getMeasuredHeight();
        canvas.translate(getWidth() / 2, getHeight() / 2);
        /*
        *
        * */
        int moveX = width / 60;
        int moveY = height / 60;
        min = Math.min(width / 2, height / 2);
//        canvas.drawCircle(width/2,height/2, min -difX,paint);
        paintCircle(canvas);
        paintScale(canvas);
      /*  paint.setColor(Color.BLACK);
        for(int i =0;i<15;i++) {

            canvas.drawLine(difX+moveX*i,height/2+moveY*i,difX+moveX*i+lineWith,height/2+moveY*i-30,paint);

        }*/

        canvas.restore();
    }

    int mColorLong = Color.BLACK;
    int mColorShort = Color.BLUE;
    //边距
    int mPadding = 10;
    //绘制刻度
    private void paintScale(Canvas canvas) {
 
        int lineWidth = 0;
        for (int i = 0; i < 60; i++) {
            if (i % 5 == 0) { //整点
                paint.setStrokeWidth(5);
                paint.setColor(mColorLong);
                lineWidth = 40;
                paint.setTextSize(30);
                String text = ((i / 5) == 0 ? 12 : (i / 5)) + "";
                Rect textBound = new Rect();
                paint.getTextBounds(text, 0, text.length(), textBound);
                paint.setColor(Color.BLACK);
                canvas.save();
                canvas.translate(0, -min + 15 + lineWidth + mPadding + (textBound.bottom - textBound.top) / 2);
                paint.setStyle(Paint.Style.FILL);
                canvas.rotate(-6 * i);
                canvas.drawText(text, -(textBound.right + textBound.left) / 2, -(textBound.bottom + textBound.top) / 2, paint);
                canvas.restore();
            } else { //非整点
                lineWidth = 30;
                paint.setColor(mColorShort);
                paint.setStrokeWidth(3);
            }
            canvas.drawLine(0, -min + mPadding, 0, -min + mPadding + lineWidth, paint);
            canvas.rotate(6);
        }
    }
    //绘制外圆背景
    public void paintCircle(Canvas canvas) {
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(0,0, min, paint);
    }
}
