package com.bing.test;

import com.bing.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        // ApplicationContext就是容器
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("one.xml");
        // 从容器中拿到指定的bean对象
        User user = (User) context.getBean("user");
        System.out.println(user);
    }
}
