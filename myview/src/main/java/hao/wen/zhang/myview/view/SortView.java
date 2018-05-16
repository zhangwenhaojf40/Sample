package hao.wen.zhang.myview.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import java.util.ArrayList;

import hao.wen.zhang.myview.R;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/15 0015 on 上午 10:59
 * 描述说明：
 */

public class SortView extends BaseView {
    /*
    * 监听触摸接口
    * */
    TouchABC touch;
    /*
    * 间距
    * */
    int mOffset;
    private static final String[] WORDS = new String[]{
            "↑", "☆", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
            "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
            "X", "Y", "Z", "#"
    };
    ArrayList<Integer> heights = new ArrayList<>();
    private int oneHeight;

    public SortView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initSet();


    }

    private void initSet() {
        paint.setTextSize(38);
        mOffset = dp2px(7);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        oneHeight = getMeasuredHeight() / (WORDS.length);
        for(int i=0;i<WORDS.length-1;i++) {
            //所有字母对用的高度  放入集合中
            heights.add(oneHeight * (i + 1));

        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //一个高度

        for(int i =0;i<WORDS.length-1;i++) {
            //文字的大小
            float size = paint.measureText(WORDS[i]);

            float x = width/2 - size / 2;
            float y = (getMeasuredHeight() / (WORDS.length) / 2 - size / 2) + oneHeight * (i + 1);
            canvas.drawText(WORDS[i],x,y,paint);


        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                float y = event.getY();
                //判断高度
                touch.touchABC(touchHeight(y));;
                break;
        }
        return true;

    }
    public void setTouchAbc(TouchABC touchAbc) {
        this.touch = touchAbc;

    }

    public String   touchHeight(float y) {
        String ABC = "";
        /*
        *
        * 遍历所有高度的集合    如果高度-触摸高度<一个字母的高度   说明在范围内   则返回该字母
        * */
        for(int i =0;i<heights.size()-1;i++) {
            if (heights.get(i) - y < oneHeight) {//返回对应的该字母

                ABC = WORDS[i];
            }
        }

        return ABC;
    }
    public interface TouchABC{
        void touchABC(String abc);
    }
}
