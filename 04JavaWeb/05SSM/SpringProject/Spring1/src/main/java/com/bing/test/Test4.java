package com.bing.test;

import com.bing.pojo.Employee;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        // 通过xml配置文件，创建ApplicationContext容器对象
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("two.xml");
        Employee employee = (Employee) context.getBean("employee");
        employee.sayHi();
        employee.showCar();
        employee.showHobbies();
        employee.showMoney();
        employee.showScore();
    }
}
