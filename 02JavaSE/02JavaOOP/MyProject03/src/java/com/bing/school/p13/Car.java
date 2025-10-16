package com.bing.school.p13;

/**
 * 汽车类
 */
public abstract class Car {
    //车牌号
    private String no;
    //车辆类型
    private String type;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Car() {
    }

    public Car(String no, String type) {
        this.no = no;
        this.type = type;
    }

    // 车辆的行驶方法
    public abstract void run(int speed);


}
