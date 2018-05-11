package yy.hao.com.testphonemvp.selfview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.Calendar;

import yy.hao.com.testphonemvp.R;
import yy.hao.com.testphonemvp.util.DpUtils;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/10 0010 on 下午 4:42
 * 描述说明：
 */

public class WatchView extends View {
    /*
    * 半径
    * */
    float radius;
    /*
    *圆的颜色
    * */
    int colorCirlce;

    private Paint paint;
    private Canvas canvas;
    private int width;
    private int height;
    //圆点宽度
    private int mWidth;
    //圆点高度
    private int mHeight;

    public WatchView(Context context) {
        super(context);
    }

    public WatchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray type = context.obtainStyledAttributes(attrs, R.styleable.WatchView);
        colorCirlce = type.getColor(R.styleable.WatchView_colorCircle, Color.WHITE);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(colorCirlce);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        /*
        * 判断wrap 情况
        * */

        if (widthMode == MeasureSpec.AT_MOST) {
            widthSize = DpUtils.dip2px(500);
        }
        if (heightMode == MeasureSpec.AT_MOST) {
            heightSize = DpUtils.dip2px(500);
        }
        setMeasuredDimension(widthSize, heightSize);
    }

    //mHeight - radius+120
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;
        width = getMeasuredWidth();
        height = getMeasuredHeight();

        mWidth = width / 2;
        mHeight = height / 2;

        //画圆
        drawCircle();

        //画刻度

        drawScale();

        //表心
        drawPoints();

        //时针

        drawHour();
        postInvalidateDelayed(1000);


    }

    private void drawHour() {
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        paint.setColor(Color.BLACK);
        //时针旋转
        canvas.save();
        canvas.rotate(30 * hour, mWidth, mHeight);
        if (Build.VERSION.SDK_INT >= 21)
            //mWidth-线的宽度   宽度为20
            canvas.drawRoundRect(mWidth - 20 / 2, mHeight - radius + 100, mWidth + 10, mHeight + 60, 10, 10, paint);
        canvas.restore();

        //分针旋转
        canvas.save();
        canvas.rotate(6 * minute, mWidth, mHeight);
        if (Build.VERSION.SDK_INT >= 21)
            canvas.drawRoundRect(mWidth - 20 / 2, mHeight - radius + 120, mWidth + 8, mHeight + 60, 10, 10, paint);
        canvas.restore();
        //秒旋转
        canvas.save();
        canvas.rotate(6 * second, mWidth, mHeight);
        paint.setColor(Color.RED);
        canvas.rotate(12, mWidth, mHeight);
        if (Build.VERSION.SDK_INT >= 21)
            canvas.drawRoundRect(mWidth - 20 / 2, mHeight - radius + 130, mWidth + 5, mHeight + 60, 10, 10, paint);
        canvas.restore();
    }

    private void drawPoints() {
        paint.setColor(Color.RED);
        canvas.drawCircle(mWidth, mHeight, 30, paint);


    }

    private void drawScale() {
        //刻度颜色
        paint.setColor(Color.BLACK);
        paint.setTextSize(30);

        for (int i = 0; i < 60; i++) {
            if (i % 5 == 0) {
                paint.setStrokeWidth(4);
                canvas.drawLine(mWidth, mHeight - radius + 8, mWidth, mHeight - radius + 40, paint);
                if ("0".equals(String.valueOf(i / 5))) {
                    canvas.drawText(String.valueOf(12), mWidth - paint.measureText("1") / 2, mHeight - radius + 80, paint);
                } else {

                    canvas.drawText(String.valueOf(i / 5), mWidth - paint.measureText("1") / 2, mHeight - radius + 80, paint);
                }
            } else {
                paint.setStrokeWidth(2);
                canvas.drawLine(mWidth, mHeight - radius + 8, mWidth, mHeight - radius + 30, paint);
            }

            canvas.rotate(6, mWidth, mHeight);
        }

    }

    public void drawCircle() {
        paint.setColor(colorCirlce);
        radius = Math.min(width / 2, height / 2);

        canvas.drawCircle(mWidth, mHeight, radius, paint);
    }
}
