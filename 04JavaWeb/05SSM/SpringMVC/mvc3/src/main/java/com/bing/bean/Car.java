package com.bing.bean;

import lombok.Data;

@Data
public class Car {
    private String name;
    private Integer price;

    public Car(){
        System.out.println("Car对象被创建了....");
    }
}
