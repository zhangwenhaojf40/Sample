package hao.wen.zhang.myview.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatEditText;
import android.text.InputFilter;
import android.util.AttributeSet;

import hao.wen.zhang.myview.R;
import hao.wen.zhang.myview.util.DpUtils;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/18 0018 on 下午 1:43
 * 描述说明：
 */

public class PassWordView extends AppCompatEditText {
    /*
    * 字符长度
    * */
    int textLeng;
    //一个距离
    int oneSpace = 20;
    private int width;
    private int height;
    private Paint paint;
    private int oneWidth;
    int maxCount = 6;
    private Context context;

    public PassWordView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;

        //获取属性
        setAttr(context, attrs);
        //去除背景和光标
        this.setBackgroundColor(Color.TRANSPARENT);
        this.setCursorVisible(false);
        //限制最大输入字数
        setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxCount)});
        initPaint();

    }

    private void setAttr(Context context, AttributeSet attrs) {
        TypedArray type = context.obtainStyledAttributes(attrs, R.styleable.PassWordView);
        maxCount = type.getInteger(R.styleable.PassWordView_maxCount, 6);
        type.recycle();

    }

    private void initPaint() {
        paint = new Paint();
        paint.setAntiAlias(true);

        paint.setColor(Color.GRAY);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        if (heightMode == MeasureSpec.AT_MOST) {//
            height = DpUtils.dip2px(context, 50);
        }
        setMeasuredDimension(width,height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setStrokeWidth(2);
//        super.onDraw(canvas);

        //一个线的宽度
        oneWidth = (width - oneSpace*(maxCount+1)) / maxCount;

        for (int i = 0; i < maxCount; i++) {

            canvas.drawLine((i + 1) * oneSpace + i * oneWidth, getHeight() / 2, (i + 1) * oneSpace + (i + 1) * oneWidth, getHeight() / 2, paint);


        }
        //画圆心
        drawPoints(canvas);

    }

    private void drawPoints(Canvas canvas) {
        paint.setStrokeWidth(10);
        paint.setColor(Color.BLACK);
        //找到圆心  -> 一个宽度/2  +一个间距
        for (int i = 0; i < textLeng; i++) {
            canvas.drawPoint((i + 1) * oneSpace + i * oneWidth + oneWidth / 2, getHeight() / 2 - DpUtils.dip2px(context,10), paint);
        }
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        textLeng = text.length();
        if (maxCount == textLeng) {
            if (listen != null) {
                listen.inputFinish(text.toString());
            }
        }
        invalidate();
    }

    OnPassWordListen listen;


    public interface OnPassWordListen {
        void inputFinish(String pwd);
    }

    public void setOnPassWordLisen(OnPassWordListen lisen) {
        listen = lisen;
    }
}
