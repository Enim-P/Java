package com.bing.p5;

/**
 * 汽车工厂类
 */
public class CarFactory {
    // 工厂生产汽车的方法
    public static Car createCar(String no,String name,int price,String type,int load){
        Car car = null;
        switch (type){
            case "轿车":
                car = new MiniCar(no,name,price);
                break;
            case "卡车":
                car = new Truck(no,name,price,load);
                break;
        }
        return  car;
    }
}
