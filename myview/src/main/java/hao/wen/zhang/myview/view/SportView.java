package hao.wen.zhang.myview.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.DecelerateInterpolator;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/21 0021 on 下午 2:04
 * 描述说明：
 */

public class SportView extends BaseView{
    /*
    * 半径
    * */
    private int radius;

    private  RectF rectF;
    /*
    * 当前步数
    * */
    private int current;
    /*
    * 最高为 1W步
    * */
    int count = 10000;
    private int animatedValue;

    public SportView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        initPaint();
    }

    private void initPaint() {
        rectF = new RectF();

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        radius = Math.min(width / 2, height / 2)-dp2px(10)/2;
        rectF.left = -radius;
        rectF.top = -radius;
        rectF.right = +radius;
        rectF.bottom = +radius;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(width/2,height/2);
        //画背景弧度
        drawArcBg(canvas);
        //画进度弧度
        drawArc(canvas);

        //写文字
        drawText(canvas);

    }

    private void drawArc(Canvas canvas) {
        paint.setColor(Color.RED);
        //步数和 度数的比例
        float scale = (float) 300 / 10000;
        //当前步数 * 比例  得出度数
        float number = animatedValue * scale;
        canvas.drawArc(rectF,120,number,false,paint);
    }

    private void drawArcBg(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(dp2px(10));
        paint.setColor(Color.BLUE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        //start -> right  顺时针 开始   画300度数   false 为不连线只画弧度
        canvas.drawArc(rectF,120,300,false,paint);
    }

    private void drawText(Canvas canvas) {
        paint.setColor(Color.RED);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setStrokeWidth(1);
        paint.setTextSize(dp2px(15));
        canvas.drawText(String.valueOf(animatedValue),0,0,paint);
    }

    public void setProgress(int current) {

        this.current = current;
        initAnimation();


    }
    public void initAnimation() {
        ValueAnimator valueAnimator =ValueAnimator.ofInt(0,current);
        valueAnimator.setDuration(1000);
        valueAnimator.setInterpolator(new DecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                animatedValue = (int) animation.getAnimatedValue();

                invalidate();

            }
        });
        valueAnimator.start();
    }
}
