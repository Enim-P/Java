package com.bing.test;

import com.bing.pojo.Teacher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        // 通过xml配置文件，创建ApplicationContext容器对象
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("one.xml");
        // 拿到Teacher对象
        Teacher teacher = context.getBean(Teacher.class);
        int len = teacher.strLength("Hello World");
        System.out.println(len);
    }
}
