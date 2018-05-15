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
    int startX;
    int startY;
    private float x;
    private float y;
    int radius=40;
    private Rect rect;
    boolean isContains;

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
        if (x == 0 && y == 0) {
            x = width / 2;
            y = height / 2;
        }
        Log.e("bb", "onDraw: "+x+"==="+y );
        canvas.drawCircle(x,y,radius,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();
        Log.e("bb", "onTouchEvent: "+x+"==="+y );
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                Log.e("aa", "onTouchEvent: "+"down" );
                break;
                case MotionEvent.ACTION_MOVE:

                    if (isContains()) {//在范围之内  随之移动
                        invalidate();

                    }
                    Log.e("bb", "onTouchEvent: "+isContains() );
                    break;
                case MotionEvent.ACTION_UP:
                Log.e("aa", "onTouchEvent: "+"up" );
                break;
        }
        return true;

    }

    public boolean isContains() {

            rect.left = startX- radius;
            rect.top = startY- radius;

            rect.right =startX+ radius;
            rect.bottom = startY + radius;




        return  rect.contains((int) x, (int) y);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Log.e("bb", "onSizeChanged: "+w+"*****"+h );
        startX = w / 2;
        startY = h / 2;
    }
}
