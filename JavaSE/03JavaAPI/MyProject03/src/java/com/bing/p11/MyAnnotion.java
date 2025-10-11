package com.bing.p11;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//@Target(ElementType.TYPE)  //@Target元注解：标记这个注解子在什么成员中使用（类、方法、字段、参数）
@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME) //@Retention元注解：标记这个注解保存的位置（源码、class、运行时 ）
public @interface MyAnnotion {
    // 在注解中添加属性，属性名称，如果叫value，在使用注解时可以省略
    // default关键字设置默认值
    String value() default "";
}
