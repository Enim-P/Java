package com.bing.test;

import com.bing.pojo.School;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("one.xml");

        School school = (School) context.getBean("school");
        System.out.println(school);

        // 手动销毁容器
        context.close();
        // 容器销毁后，无法再创建bean
        /*School school2 = (School) context.getBean("school");
        System.out.println(school2);*/
    }
}
