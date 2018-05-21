package hao.wen.zhang.myview.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.LinearInterpolator;
import android.widget.TextView;

import java.util.ArrayList;

import hao.wen.zhang.myview.view.BaseView;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/21 0021 on 上午 10:39
 * 描述说明：
 */

public class MyTextView extends TextView {
    /*
    * 每个字符间隔的时间
    * */
    int duration=300;
    /*
    * 动画监听   防止重复
    * */
    int current=-1;

    ArrayList<String> arr = new ArrayList<>();
    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }



    public void setTextContent(String text) {
        if (text != null) {
            for(int i=0;i<text.length();i++) {
                arr.add(text.substring(i, i + 1));
            }
            initAnimation();
        }
    }

    StringBuilder sb = new StringBuilder();

    public void initAnimation() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, arr.size()-1);
        valueAnimator.setDuration(duration * arr.size());
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

               int index= (int) animation.getAnimatedValue();
                if (current != index) {
                    sb.append(arr.get(index));

                    setText(sb.toString());
                }

                current = index;
            }
        });
        valueAnimator.start();
    }

}
