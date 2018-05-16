package hao.wen.zhang.myview.view;

import android.animation.ValueAnimator;
import android.appwidget.AppWidgetHost;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.LinearInterpolator;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/16 0016 on 下午 5:14
 * 描述说明：
 */

public class LinearProgressView extends BaseView {

    private String TAG="LinearProgressView";

    public LinearProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.e(TAG, "onMeasure: " );
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.e(TAG, "onSizeChanged: " );

        paint.setStrokeWidth(height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e(TAG, "canvas: " );
        paint.setColor(Color.GRAY);
        canvas.drawLine(0,0, width,0,paint);
        paint.setColor(Color.RED);
        canvas.drawLine(0,0, mOffset*width,0,paint);


    }

    private float mOffset;
    public void startAnimation() {
        Log.e(TAG, "startAnimation: " );
        ValueAnimator animator = ValueAnimator.ofFloat(0, 1);
        animator.setDuration(3000);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {


            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mOffset = (float) animation.getAnimatedValue();
                invalidate();
            }
        });
        animator.start();
    }
}
