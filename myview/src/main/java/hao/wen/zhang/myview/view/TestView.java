package hao.wen.zhang.myview.view;

import android.appwidget.AppWidgetHost;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/18 0018 on 上午 10:37
 * 描述说明：
 */

public class TestView extends BaseView {

    public TestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(0,20,width,20,paint);
        canvas.save();
        canvas.translate(width/2,height/2);
        canvas.rotate(45);

        paint.setColor(Color.BLUE);
        canvas.drawRect(-200,-200,+200,+200,paint);
        canvas.restore();
        paint.setColor(Color.parseColor("#44ff0000"));
        canvas.drawRect(width/2-100,height/2-100, width/2+100,height/2+100,paint);

    }
}
