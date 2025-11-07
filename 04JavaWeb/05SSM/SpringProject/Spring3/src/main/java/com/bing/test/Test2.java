package com.bing.test;

import com.bing.bean.Car;
import com.bing.bean.Phone;
import com.bing.config.MainConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test2 {
    public static void main(String[] args) {
        // 创建一个使用注解配置类的ApplicationContext容器对象
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                MainConfiguration.class
        );
        Car car1 = context.getBean(Car.class);
        Car car2 = context.getBean(Car.class);
        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car1==car2);
        System.out.println("--------------------------");
        Phone phone1 = context.getBean(Phone.class);
        Phone phone2 = context.getBean(Phone.class);
        System.out.println(phone1);
        System.out.println(phone2);
        System.out.println(phone1==phone2);
    }
}
