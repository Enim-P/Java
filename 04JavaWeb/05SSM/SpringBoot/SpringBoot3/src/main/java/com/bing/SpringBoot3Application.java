package com.bing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// @SpringBootApplication注解中已经包含了@ComponentScan注解
// 它默认是扫描当前启动类所有在的包及其子包
@SpringBootApplication
public class SpringBoot3Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringBoot3Application.class, args);
    }
}

/*
    IOC：Inversion Of Contrl 控制反转
    控制反转：创建对象的过程不再是程序员，而是转移到外部的容器。
    ID：Dependency Injection 依赖注入
    依赖注入：容器在运行时，程序需要什么资源，它帮你直接注入。
    Bean对象：IOC容器中管理的对象，统称为Bean对象。

    下面就是声明Bean对象的常用注解：
    @Component  是声明bean的基础注解
    @Controller 是@Component的衍生注解，专门用于声明控制器类
    @Service    是@Component的衍生注解，专门用于声明业务逻辑类
    @Repository 是@Component的衍生注解，专门用于声明数据访问类
    添加了这些注解的类，要想被Spring管理，还需要在Spring的配置类中通过@ComponentScan注解扫描到它们
    @SpringBootApplication中，默认扫描的范围是启动类所在包及其子包
*/
