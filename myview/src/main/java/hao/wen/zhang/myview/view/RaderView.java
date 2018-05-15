package hao.wen.zhang.myview.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

import java.util.Random;

import hao.wen.zhang.myview.R;


/**
 * 作者：ZWH
 * 创建日期： 2018/5/15 0015 on 上午 11:12
 * 描述说明：
 */

public class RaderView extends BaseView {
    Random rand = new Random();
    /*
    * 外圆颜色
    * */
    private final int color;
    /*
    * 内圆颜色
    * */
    private final int colorLine;

    /*
    *半径
    * */
    private final float radius;
    /*
    * 偏移量
    * */
    private float mOffset;
    /*
    * 内圆画笔
    * */
    Paint linePaint;

    /*
    * 波纹个数
    * */
    private final int count;
    /*
    * 内圆 距离
    * */
    int mOffsetCircle=30;

    public RaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray type = context.obtainStyledAttributes(attrs, R.styleable.RaderView);
        color = type.getColor(R.styleable.RaderView_colorCircle_Rader, Color.WHITE);
        colorLine = type.getColor(R.styleable.RaderView_colorLine_Rader, Color.WHITE);
        radius = type.getDimension(R.styleable.RaderView_radius_Rader, 400);
        count = type.getInteger(R.styleable.RaderView_count, 1);
        initSet();

    }

    private void initSet() {
        linePaint = new Paint();
        linePaint.setAntiAlias(true);
        linePaint.setColor(colorLine);
        linePaint.setStyle(Paint.Style.STROKE);
        linePaint.setStrokeWidth(1);
        paint.setColor(color);
    }
    private int colorArray[] = {Color.BLACK,Color.BLACK,Color.GREEN,Color.YELLOW, Color.RED};
    //为画笔设置随机颜色
    private void setPaintRandomColor(){

        int randomIndex = rand.nextInt(colorArray.length);
        linePaint.setColor(colorArray[randomIndex]);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //外圆
        canvas.drawCircle(width/2,height/2,radius,paint);
        //内圆
        for(int i=0;i<count;i++) {
//            setPaintRandomColor();
            if (30 + mOffset +i*mOffsetCircle<= radius) {
                canvas.drawCircle(width/2,height/2,30+mOffset+i*mOffsetCircle,linePaint);
            }
        }

    }
    public void startAnimation() {
        ValueAnimator animator = ValueAnimator.ofFloat(30, radius);
        animator.setDuration(3000);
        animator.setRepeatCount(-1);
        animator.setInterpolator(new DecelerateInterpolator());
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
