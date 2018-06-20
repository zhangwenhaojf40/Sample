package hao.wen.zhang.annotations.set;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 作者：ZWH
 * 创建日期： 2018/5/30 0030   上午 11:23
 * 描述说明：
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PersonAnno {
    int age();

    String name();
}
