package hao.wen.zhang.myview.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.LinearInterpolator;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/14 0014 on 下午 1:35
 * 描述说明：
 */

public class BallView extends BaseView {

    public BallView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        canvas.drawCircle(startX,height/2,50,paint);
//        startAnimal();
    }
    private float startX;
    public void startAnimal() {
        int measuredWidth = getMeasuredWidth();
        ValueAnimator animator = ValueAnimator.ofFloat(200,1000);
        animator.setDuration(3000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {



            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                startX = (float) animation.getAnimatedValue();
                Log.e("aaa", "onAnimationUpdate: "+ startX);
                invalidate();
            }
        });
        animator.start();


    }
}
