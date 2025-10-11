package com.bing.p5;

/**
 * 汽车类
 */
public abstract class Car {
    private String no;
    private String name;
    //日租金
    private Integer price;

    public Car() {
    }

    public Car(String no, String name, Integer price) {
        this.no = no;
        this.name = name;
        this.price = price;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    // 计算总租金的方法
    public abstract Integer calcPrice(int days);
}
