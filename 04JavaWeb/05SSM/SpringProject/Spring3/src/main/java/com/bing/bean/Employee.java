package com.bing.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Data
@Component
public class Employee {
    private String name;
    private int age;

    // 使用@Autowired 或 @Resource注解，注入已经被spring管理的bean
    //@Autowired
    @Resource
    private Car car;

    /*@Resource
    public void setCar(Car car){
        this.car = car;
    }*/

    /*@Autowired
    public void setCar(Car car){
        this.car = car;
    }*/

    /*
        @Resource：默认通过ByName注入，如果找不到再通过ByType注入，可以添加在字段上、set方法上
        @Autowired：默认通过ByType注入，可以添加在字段上、set方法上、方法参数上，构造方法上
    */

    public void showCar(){
        System.out.println("显示车辆信息：");
        System.out.println(car);
    }
}
