package com.bing.test;

import com.bing.pojo.Company;
import com.bing.pojo.Manager;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test5 {
    public static void main(String[] args) {
        // 通过xml配置文件，创建ApplicationContext容器对象
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("two.xml");
        Manager manager = (Manager) context.getBean("manager");
        manager.showCar();
        System.out.println("-----------------");
        Company company = (Company) context.getBean("company");
        company.sayHi();
    }
}
