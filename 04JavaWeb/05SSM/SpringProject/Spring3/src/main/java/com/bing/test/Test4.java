package com.bing.test;

import com.bing.bean.Manager;
import com.bing.config.MainConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        // 创建一个使用注解配置类的ApplicationContext容器对象
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                MainConfiguration.class
        );
        Manager manager = context.getBean(Manager.class);
        System.out.println(manager);
        context.close();  //关闭容器
    }
}
