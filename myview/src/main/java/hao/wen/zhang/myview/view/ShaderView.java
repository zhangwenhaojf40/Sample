package hao.wen.zhang.myview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;

import hao.wen.zhang.myview.R;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/18 0018 on 上午 11:33
 * 描述说明：
 */

public class ShaderView extends BaseView {
    float x,y;
    public ShaderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x = event.getX();
        y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                invalidate();

                break;
        }

        return true;

    }

    private void initPaint() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.timg);
        paint.setShader(new BitmapShader(bitmap, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GRAY);
        canvas.drawCircle(x,y,200,paint);

    }
}
