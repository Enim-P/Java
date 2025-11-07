package com.bing.config;

import com.bing.bean.Car;
import com.bing.pojo.Student;
import com.bing.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

// 使用@Configuration注解定义的类，就是spring的配置类
// 此时这个配置类，就可以理解成之前的xml文件
@Configuration
@ComponentScan("com.bing.bean")    //扫描指定的包，将该包下面的所有类注册为spring管理的bean对象
//@ComponentScan({"com.bing.bean","com.bing.pojo"})  //扫描多个包
public class MainConfiguration {
    // 在配置类中定义bean
    @Bean  //@Bean注解，注册bean对象
    @Scope("singleton")   //设置bean对象的创建模式，默认是singleton，可以省略
    public Student student(@Autowired Car car){
        // 参数中的@Autowired可以，默认就是注入Car对象
        Student student = new Student();
        student.setCar(car);
        return student;
    }

    @Bean
    @Scope("prototype")  //采用原型模式创建bean对象
    public Teacher teacher(){
        return new Teacher();
    }
    // 注意：单例模式在容器初始化的时候，就会创建所有的bean对象，而原型模式只会在用到该bean对象时才创建
}

/*
    什么类型适合使用@Bean注解注册成bean对象交给spring容器管理呢？
    第三方类库，比如：Mybatis的工厂类
*/
