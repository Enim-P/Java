package com.bing.school.p12;

/**
 * 汽车类
 */
public abstract class Car {
    //车牌号
    private String no;
    //车名
    private String name;
    //颜色
    private String color;
    //日租金
    private double rent;
    //租车状态
    private boolean stutus;
    //租用天数
    private int days;

    public Car() {
    }

    public Car(String no, String name, String color, double rent,boolean stutus) {
        this.no = no;
        this.name = name;
        this.color = color;
        this.rent = rent;
        this.stutus = stutus;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public boolean isStutus() {
        return stutus;
    }

    public void setStutus(boolean stutus) {
        this.stutus = stutus;
    }

    @Override
    public String toString() {
        return "Car{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", rent=" + rent +
                ", days=" + days +
                '}';
    }

    //计算总租金的方法
    public abstract double calcPrice();
}
