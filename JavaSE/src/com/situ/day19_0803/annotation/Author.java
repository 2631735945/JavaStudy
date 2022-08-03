package com.situ.day19_0803.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 表示这个注解可以作用到方法、属性、类
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Author {
    // 注解属性
    // 1、修饰符为默认或者为public
    // 2、不能有方法体
    String name() default  "";

    // 带默认值的注解;  使用的时候就可以不写此属性值;
    int age() default 30;

    String value() default  "";
}
