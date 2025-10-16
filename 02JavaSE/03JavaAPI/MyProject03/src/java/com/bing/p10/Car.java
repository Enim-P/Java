package com.bing.p10;

/**
 * 汽车类
 */
public class Car {
    @Key
    public String no;
    public String name;
    public int price;

    public Car() {
    }

    public Car(String no, String name, int price) {
        this.no = no;
        this.name = name;
        this.price = price;
    }
}
