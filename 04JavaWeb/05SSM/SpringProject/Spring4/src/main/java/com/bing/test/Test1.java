package com.bing.test;

import com.bing.config.MainConfiguration;
import com.bing.pojo.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        // 创建一个使用注解配置类的ApplicationContext容器对象
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                MainConfiguration.class
        );
        Student student = context.getBean(Student.class);
        int len = student.strLength("Hello World");
        System.out.println(len);
    }
}
