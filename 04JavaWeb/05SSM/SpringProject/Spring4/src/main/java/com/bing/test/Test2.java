package com.bing.test;

import com.bing.config.MainConfiguration;
import com.bing.pojo.Teacher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        // 创建一个使用注解配置类的ApplicationContext容器对象
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                MainConfiguration.class
        );
        Teacher teacher = context.getBean(Teacher.class);
        int len = teacher.strLength("Hello World");
        System.out.println(len);
    }
}
