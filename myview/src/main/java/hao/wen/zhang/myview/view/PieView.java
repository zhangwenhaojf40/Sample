package hao.wen.zhang.myview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/23 0023 on 下午 4:48
 * 描述说明：
 */

public class PieView extends BaseView {
    /*
    * 半径
    * */
    int radius = dp2px(120);
    /*
    * 每次的弧度
    * */

    /*
    * 间隔的度数
    *
    * */
    int mOff = 3;
    int arc = 10;
    int[] colors = new int[]{Color.BLACK,Color.BLUE,Color.GRAY,Color.GREEN,Color.CYAN};
    private final RectF rectF;
    private Canvas canvas;

    public PieView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        rectF = new RectF(-radius, -radius, radius, radius);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        this.canvas = canvas;
        super.onDraw(canvas);
        canvas.translate(getWidth()/2,getHeight()/2);
        //绿色
        drawA(0,10,Color.GREEN);


        //蓝色
        paint.setColor(Color.BLUE);
        canvas.drawArc(rectF, 13, 15,true, paint);
        //黑色
        drawA(33,30,Color.BLACK);
        //红色
       drawA(66,50,Color.RED);
       //蓝色
       drawA(119,70,Color.BLUE);
       //蓝色
       drawA(192,100,Color.YELLOW);
       drawA(295,60,Color.GRAY);
    }
    public void drawA(int startAngle,int ednAngle,int color) {
        paint.setColor(color);
        canvas.drawArc(rectF,startAngle,ednAngle,true,paint);
    }


}
