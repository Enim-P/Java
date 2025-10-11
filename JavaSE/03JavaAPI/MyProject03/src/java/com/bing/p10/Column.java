package com.bing.p10;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 列注解
@Target(ElementType.FIELD)   //在字段上使用
@Retention(RetentionPolicy.RUNTIME)   //在运行时使用
public @interface Column {
    String value() default "";
}
