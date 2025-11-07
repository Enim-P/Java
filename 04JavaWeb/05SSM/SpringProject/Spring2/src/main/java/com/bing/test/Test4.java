package com.bing.test;

import com.bing.pojo.Manager;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        // 通过xml配置文件，创建ApplicationContext容器对象
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("one.xml");
        // 拿到Manager对象
        Manager manager = context.getBean(Manager.class);
        int len = manager.strLength("Hello World");
        System.out.println(len);
    }
}
