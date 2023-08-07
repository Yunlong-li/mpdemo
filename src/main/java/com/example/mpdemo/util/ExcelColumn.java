package com.example.mpdemo.util;

import java.lang.annotation.*;

/**
 * @author 刘伟
 * @program: mpdemo
 * @description: 自定义实体类所需要的bean（Excel属性标题位置等）
 * @date 2023-08-07 11:18:57
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExcelColumn {
    /**
    * @Description: Excel标题
    * @Param:
    * @return:
    * @Date: 2023/8/7
    */
    String value() default "";

    /**
    * @Description: 从左到右排列位置
    * @Param:
    * @return:
    * @Date: 2023/8/7
    */
    int col() default 0;

}
