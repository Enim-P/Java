package com.bing.test;

import com.bing.pojo.Employee;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        // 通过xml配置文件，创建ApplicationContext容器对象
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("one.xml");
        // 拿到Employee对象
        Employee employee = context.getBean(Employee.class);
        int len = employee.strLength("Hello World");
        System.out.println(len);
    }
}
