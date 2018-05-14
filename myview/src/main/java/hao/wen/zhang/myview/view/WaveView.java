package hao.wen.zhang.myview.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/14 0014 on 上午 10:34
 * 描述说明：
 */

public class WaveView extends BaseView{
    /*
    * 波长
    * */
    int waveLong=1080;
    /*
    * 偏移量
    * */
    int mOffset;
    /*
    * 振幅高度
    * */
    float waveHeight;
//    float offHeight = 100;
    private final Path path;

    public WaveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        path = new Path();
//        waveLong = dp2px(500);
        waveHeight = dp2px(10);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawP(canvas);
     /*   path.reset();
        String text = "贝塞尔曲线的实现";
        paint.setTextSize(45);
        canvas.drawText(text,width/2-paint.measureText(text)/2,200,paint);

        path.moveTo(-waveLong+mOffset, waveHeight);
        for(int i =0;i<2;i++) {

            path.quadTo(-waveLong/4*3+mOffset+i*waveLong,-waveHeight,-waveLong/2+i*waveLong+mOffset,waveHeight);
            path.quadTo(-waveLong/4+mOffset+i*waveLong,3 * waveHeight,mOffset+i*waveLong,waveHeight);
        }
        path.lineTo(getWidth(), getHeight());
        path.lineTo(0, getHeight());
        path.close();

        canvas.drawPath(path,paint);*/


    }

    private void drawP(Canvas canvas) {
       path.reset();
       path.moveTo(-waveLong+mOffset,waveHeight);
       for(int i=0;i<2;i++) {

           path.quadTo(-waveLong/4*3+mOffset+i*waveLong,-waveHeight,-waveLong/2+mOffset+i*waveLong,waveHeight);
           path.quadTo(-waveLong/4+mOffset+i*waveLong,waveHeight*3,i*waveLong+mOffset,waveHeight);
       }
       path.lineTo(getWidth(),getHeight());
       path.lineTo(0,getHeight());
       path.close();
       canvas.drawPath(path,paint);

    }

    private void initAnimation() {
        ValueAnimator  valueAnimator = ValueAnimator.ofInt(0, 1080);
        valueAnimator.setDuration(2000);
        valueAnimator.setStartDelay(300);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mOffset = (int) animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.start();
    }

    public void startAnimation() {
        initAnimation();
    }
}
