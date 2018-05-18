package hao.wen.zhang.myview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/15 0015 on 下午 2:05
 * 描述说明：
 */

public class TouchBallView extends BaseView {

    private float x;
    private float y;
    int radius=40;
    private Rect rect;
    boolean isContains;
    private float donwX;
    private float donwY;

    public TouchBallView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initSet();
        isContains();

    }

    private void initSet() {
        paint.setColor(Color.RED);
        rect = new Rect();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(x,y,radius,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                donwX = event.getX();
                donwY = event.getY();
                //判断是否点中圆点
                isContains();
                break;
                case MotionEvent.ACTION_MOVE:
                    if (isContains) {//如果点中圆点  则重新绘制 移动

                        invalidate();
                    }
                    break;
                case MotionEvent.ACTION_UP:
                    if (isContains) {//如果点中圆点  则重新设置矩形范围
                        setRect();
                    }
                break;
        }
        return true;

    }
    public void isContains() {
      isContains= rect.contains((int)donwX, (int)donwY);


    }
    public void  setRect() {

            rect.left = (int) (x- radius);
            rect.top = (int) (y- radius);

            rect.right = (int) (x+ radius);
            rect.bottom = (int) (y + radius);




    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        x = w / 2;
        y = h / 2;
        setRect();
    }
}
