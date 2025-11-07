package com.bing.test;

import com.bing.bean.Employee;
import com.bing.config.MainConfiguration;
import com.bing.pojo.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test3 {
    public static void main(String[] args) {
        // 创建一个使用注解配置类的ApplicationContext容器对象
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                MainConfiguration.class
        );
        Employee employee = context.getBean(Employee.class);
        employee.showCar();
        System.out.println("-------------------------");
        Student student = context.getBean(Student.class);
        System.out.println(student.getCar());
    }
}
