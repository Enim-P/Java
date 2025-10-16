package com.bing.p11;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface MyAnnotion3 {
    // 注解中的属性，也可以是一个数组
    String[] value();
}
