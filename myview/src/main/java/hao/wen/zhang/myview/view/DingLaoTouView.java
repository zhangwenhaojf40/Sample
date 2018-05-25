package hao.wen.zhang.myview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/23 0023 on 下午 3:32
 * 描述说明：
 */

public class DingLaoTouView extends BaseView {
    float radius = dp2px(80);
    //小圆
    float radiusSmall = dp2px(20);
    //矩形
    float radiusArc = dp2px(60);
    private final Path path;
    private final RectF rectF;

    public DingLaoTouView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        path = new Path();
        rectF = new RectF(-radiusArc, -radiusArc, radiusArc, radiusArc);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.translate(getWidth()/2,getHeight()/2);
        //画大圆
        canvas.drawCircle(0,0,radius,paint);
        //画丁字
        path.moveTo(-dp2px(20),-radius+dp2px(20));
        path.lineTo(dp2px(20),-radius+dp2px(20));
        path.moveTo(0,-radius+dp2px(20));
        path.lineTo(0,radius-dp2px(30));
        path.lineTo(-dp2px(10),radius-dp2px(40));
        canvas.drawPath(path,paint);



        //画小圆
        canvas.drawCircle(-radiusSmall-10,0,radiusSmall,paint);
        canvas.drawCircle(radiusSmall+10,0,radiusSmall,paint);
        //画扇形   水平右边 为起止点  150-》起点 顺时针 150度 -120逆时针
        canvas.drawArc(rectF,150,-120,false,paint);

    }
}
