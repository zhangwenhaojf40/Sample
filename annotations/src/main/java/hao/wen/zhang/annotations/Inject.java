package hao.wen.zhang.annotations;

import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/29 0029   下午 4:01
 * 描述说明：
 */

public class Inject {
    public static void inJect(AppCompatActivity activity) {

        try {
            bindRes(activity);//绑定布局
            bindView(activity);//查找控件
            bindClick(activity);//查找控件

        } catch (Exception  e) {

            e.printStackTrace();
        }
    }

    private static void bindClick(AppCompatActivity activity) {
        Class<? extends AppCompatActivity> clz = activity.getClass();
        Method[] methods = clz.getMethods();//得到所有方法
        for (Method method : methods) {
            if (method.isAnnotationPresent(BindClick.class)) {//方法下是否有BindClick注解
                BindClick annotation = method.getAnnotation(BindClick.class);
                int[] value = annotation.value();
                for (int id : value) {
                    View view=activity.findViewById(id);
                    view  .setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    method.setAccessible(true);
                                    try {
                                        method.invoke(activity, view);
                                    } catch (IllegalAccessException e) {
                                        e.printStackTrace();

                                    } catch (InvocationTargetException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                }


            }
        }

    }

    private static void bindRes(AppCompatActivity activity) {
        Class<? extends AppCompatActivity> clz = activity.getClass();
        BindRes annotation = clz.getAnnotation(BindRes.class);
        if (annotation != null) {
            int value = annotation.value();
            activity.setContentView(value);
        }
    }

    public static void bindView(AppCompatActivity activity) throws IllegalAccessException {
        Class<? extends AppCompatActivity> clz = activity.getClass();
        Field[] fields = clz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {

            if (fields[i].isAnnotationPresent(Bind.class)) {
                Bind bind = fields[i].getAnnotation(Bind.class);
                int value = bind.value();
                View view = activity.findViewById(value);
                fields[i].setAccessible(true);

                    fields[i].set(activity, view);

            } else {
                System.out.println("没有");
            }
//            System.out.println(fields[i]);
        }
    }
}
