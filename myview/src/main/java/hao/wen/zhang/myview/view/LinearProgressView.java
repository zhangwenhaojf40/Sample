package hao.wen.zhang.myview.view;

import android.animation.ValueAnimator;
import android.appwidget.AppWidgetHost;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.LinearInterpolator;

import hao.wen.zhang.myview.R;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/16 0016 on 下午 5:14
 * 描述说明：
 */

public class LinearProgressView extends BaseView {

    private String TAG="LinearProgressView";
    private final int total;

    public LinearProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray type = context.obtainStyledAttributes(attrs, R.styleable.LinearProgressView);
        total = type.getInteger(R.styleable.LinearProgressView_progress_linear, 0);

    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);


        paint.setStrokeWidth(dp2px(3));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //背景线
        drawBg(canvas);

        //进度条
        drawPg(canvas);

        //文字
        drawTx(canvas);





    }

    StringBuilder sb = new StringBuilder();
    /*
    * 文字
    * */
    private void drawTx(Canvas canvas) {
        sb.setLength(0);
        paint.setTextSize(45);

        int  progress = (int) (mOffset * 100);
        //开始位置
        int  startX= (int) (mOffset * width);
        paint.setTextAlign(Paint.Align.CENTER);

        canvas.drawText(sb.append(String.valueOf(progress)).append("%").toString(),startX,height/2-dp2px(7),paint);

    }
    /*
    * 画进度条
    * */
    private void drawPg(Canvas canvas) {
        paint.setColor(Color.RED);
        canvas.drawLine(0,height/2, mOffset*width,height/2,paint);
    }

    /*
    * 画灰色线
    * */
    private void drawBg(Canvas canvas) {
        paint.setColor(Color.GRAY);
        canvas.drawLine(0,height/2, width,height/2,paint);
    }

    private float mOffset;
    public void startAnimation() {
        ValueAnimator animator = ValueAnimator.ofFloat(0, 1);
        animator.setDuration(3000);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {


            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                if (total > mOffset * 100) {

                    mOffset = (float) animation.getAnimatedValue();
                    invalidate();
                }
            }
        });
        animator.start();
    }
}
