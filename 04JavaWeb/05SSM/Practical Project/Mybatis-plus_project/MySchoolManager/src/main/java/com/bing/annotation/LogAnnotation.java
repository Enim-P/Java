package com.bing.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用于标记为是否需要添加日志信息的组件
 */
@Retention(RetentionPolicy.RUNTIME)   //运行时生效
@Target(ElementType.METHOD)           //作用在方法上
public @interface LogAnnotation {
}
