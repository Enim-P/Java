package com.bing.p5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Company {
    Scanner input = new Scanner(System.in);
    // 可租车辆集合
    private Map<String,Car> list1 = new HashMap<>();
    // 已租车辆集合
    private Map<String,Car> list2 = new HashMap<>();
    public Company(){
        // 调用工厂生产汽车
        Car c1 = CarFactory.createCar("苏A1001","奔驰",2000,"轿车",0);
        Car c2 = CarFactory.createCar("苏A1002","宝马",1600,"轿车",0);
        Car c3 = CarFactory.createCar("苏A1003","奥迪",1500,"轿车",0);
        Car c4 = CarFactory.createCar("苏A1004","东风",2200,"卡车",20);
        Car c5 = CarFactory.createCar("苏A1005","解放",2600,"卡车",25);
        Car c6 = CarFactory.createCar("苏A1006","五菱",3000,"卡车",30);
        list1.put(c1.getNo(),c1);
        list1.put(c2.getNo(),c2);
        list1.put(c3.getNo(),c3);
        list1.put(c4.getNo(),c4);
        list1.put(c5.getNo(),c5);
        list1.put(c6.getNo(),c6);
    }
    // 查看车辆
    private void show(){
        System.out.println("*******可借车辆信息*******");
        System.out.println("车牌\t\t车名\t日租金\t车型\t载重");
        list1.values().forEach(car->{
            System.out.print(car.getNo()+"\t"+car.getName()+"\t"+
                    car.getPrice()+"\t");
            if(car instanceof Truck){
                Truck truck = (Truck) car;
                System.out.println("卡车\t"+truck.getLoad());
            }else{
                System.out.println("轿车\t无");
            }
        });
        System.out.println("-----------------------------");
        System.out.println("*******已借车辆信息*******");
        System.out.println("车牌\t\t车名\t日租金\t车型\t载重");
        list2.values().forEach(car->{
            System.out.print(car.getNo()+"\t"+car.getName()+"\t"+
                    car.getPrice()+"\t");
            if(car instanceof Truck){
                Truck truck = (Truck) car;
                System.out.println("卡车\t"+truck.getLoad());
            }else{
                System.out.println("轿车\t无");
            }
        });
    }
    // 租用车辆
    private void rent(){
        System.out.println("*******租用车辆*******");
        System.out.print("请输入租用车辆的车牌号：");
        String no = input.next();
        //判断车辆是否可借
        if(list1.containsKey(no)){
            // 将车辆移动到借出集合
            list2.put(no,list1.get(no));
            // 架构车辆从可借集合中移除
            list1.remove(no);
            System.out.println("车辆租用成功！");
        }else{
            //判断车辆是否已借出
            if(list2.containsKey(no)){
                System.out.println("您输入的车辆已经借出！");
            }else{
                System.out.println("您输入的车牌号不存在！");
            }
        }
    }
    // 归还车辆
    private void still(){
        System.out.println("*******归还车辆*******");
        System.out.print("请输入归还车辆的车牌号：");
        String no = input.next();
        if(list2.containsKey(no)){
            System.out.print("请输入使用天数：");
            int days = input.nextInt();
            // 计算总租金
            int total = list2.get(no).calcPrice(days);
            System.out.println("您需要支付总租金为："+total);
            list1.put(no,list2.get(no));
            list2.remove(no);
        }else{
            if(list1.containsKey(no)){
                System.out.println("您输入的车辆无需归还！");
            }else{
                System.out.println("您输入的车牌号不存在！");
            }
        }
    }
    // 新车入库
    private void add(){
        System.out.println("*******车辆入库*******");
        System.out.print("请输入车库牌号");
        String no = input.next();
        if(list1.containsKey(no) || list2.containsKey(no)){
            System.out.println("车牌号已经存在！");
            return;
        }
        System.out.print("请输入车辆名称：");
        String name = input.next();
        System.out.print("请输入车辆价格：");
        int price = input.nextInt();
        System.out.print("请输入车辆类型（轿车/卡车）：");
        String type = input.next();
        int load = 0;  //载重默认是0
        if(type.equals("卡车")){
            System.out.print("请输入卡车的载重：");
            load = input.nextInt();
        }
        // 调用工厂提交需求，生产汽车
        Car car = CarFactory.createCar(no,name,price,type,load);
        list1.put(no,car);
        System.out.println("车辆入库成功！");
    }
    // 车辆出库
    private void del(){
        System.out.println("*******车辆出库*******");
        System.out.print("请输入出库车辆的车牌号：");
        String no = input.next();
        if(list1.containsKey(no)){
            list1.remove(no);
            System.out.println("车辆出库成功！");
        }else{
            if(list2.containsKey(no)){
                System.out.println("您输入的车辆已经借出！");
            }else {
                System.out.println("您输入的车牌号不存在！");
            }
        }
    }

    // 菜单方法
    public void menu(){
        System.out.println("************车辆租赁*************");
        System.out.println("1.查看可租用车辆信息");
        System.out.println("2.租用车辆");
        System.out.println("3.归还车辆");
        System.out.println("4.新车入库");
        System.out.println("5.车辆出库");
        System.out.println("0.退出系统");
        System.out.println("********************************");
        System.out.print("请选择：");
        int no = input.nextInt();
        if(no==1){
            show();
        }else if(no==2){
            rent();
        }else if(no==3){
            still();
        }else if(no==4){
            add();
        }else if(no==5){
            del();
        }else{
            System.out.println("成功退出！");
            return;
        }
        menu();  //递归调用
    }
}
