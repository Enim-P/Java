package com.bing;

import com.bing.pojo.Student;
import com.bing.pojo.Teacher;
import com.bing2.pojo.Car;
import com.bing3.pojo.Phone;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringBoot6ApplicationTests {

    // 在注入单例Bean对象之前，其实它已经被创建好，存储容器中
    @Resource
    Student student;

    // 在注入多实例Bean对象的时候，才会去创建Bean对象，而且是注入一次创建一次
    @Resource
    Teacher teacher;

    // 注入Spring管理的Bean
    @Resource
    SAXReader saxReader;

    @Resource
    Car car;

    @Resource
    Phone phone;

    @Test
    void contextLoads() {
        System.out.println(student);
    }

    @Test
    void text2(){
        // 手动创建对象
        SAXReader saxReader = new SAXReader();
        System.out.println(saxReader);
    }

    @Test
    void text3(){
        System.out.println(saxReader);
    }

    @Test
    void test4(){
        System.out.println(car);
    }

    @Test
    void test5(){
        System.out.println(phone);
    }

}
