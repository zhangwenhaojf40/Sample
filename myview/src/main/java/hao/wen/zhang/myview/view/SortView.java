package hao.wen.zhang.myview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/15 0015 on 上午 10:59
 * 描述说明：
 */

public class SortView extends BaseView {
    /*
    * 间距
    * */
    int mOffset;
    private static final String[] WORDS = new String[]{
            "↑", "☆", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
            "X", "Y", "Z", "#"
    };

    public SortView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initSet();


    }

    private void initSet() {
        paint.setTextSize(38);
        mOffset = dp2px(7);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //一个高度
        int oneHeight = getMeasuredHeight() / (WORDS.length);
        for(int i =0;i<WORDS.length-1;i++) {
            //文字的大小
            float size = paint.measureText(WORDS[i]);

            float x = getWidth() - dp2px(30) - size / 2;
            float y = (getMeasuredHeight() / (WORDS.length) / 2 - size / 2) + oneHeight * (i + 1);
            canvas.drawText(WORDS[i],x,y,paint);


        }
    }
}
