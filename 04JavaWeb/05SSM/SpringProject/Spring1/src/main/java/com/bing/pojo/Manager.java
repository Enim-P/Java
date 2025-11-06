package com.bing.pojo;

public class Manager {

    private Car car;

    public Car getCar() {
        return car;
    }

    // 如果是根据类型自动注入，就是根据set方法中参数的类型去注入
    // 如果该参数类型已经在IoC容器中存在对应的bean，就将该bean对象注入进来
    public void setCar(Car car) {
        this.car = car;
    }

    public void showCar(){
        System.out.println("我的车辆信息："+car);
    }

}
