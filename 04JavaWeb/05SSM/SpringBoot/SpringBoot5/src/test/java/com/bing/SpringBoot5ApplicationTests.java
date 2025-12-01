package com.bing;

import com.bing.pojo.Employee;
import com.bing.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SpringBoot5ApplicationTests {
    /*
        AOP：Aspect Oriented Programming（面向切面编程、面向方面编程），其实就是面向特定方法编程。
        在不改变原始方法的基础上，对原始方法进行增强。
    */

    @Resource
    StudentService studentService;
    @Resource
    EmployeeService employeeService;
    @Resource
    CarService carService;
    @Resource
    PhoneService phoneService;
    @Resource
    PCService pcService;

    @Test
    void test1() {
        String ret = studentService.sayHi();
        System.out.println(ret);
    }

    @Test
    void test2(){
        String ret = studentService.sayHello();
        System.out.println(ret);
    }

    @Test
    void test3(){
        List<Employee> employees = employeeService.getEmployees();
        employees.forEach(System.out::println);
    }

    @Test
    void test4(){
        carService.showCar();
    }

    @Test
    void test5(){
        phoneService.showPhone();
        pcService.showPC();

    }
}
