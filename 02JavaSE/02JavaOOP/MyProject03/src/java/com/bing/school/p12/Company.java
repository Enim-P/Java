package com.bing.school.p12;

import java.lang.annotation.Retention;
import java.util.Scanner;

/**
 * 租赁公司类
 */
public class Company {
    Scanner input = new Scanner(System.in);
    // 初始化一个汽车数组
    private Car[] cars = {
            new MiniCar("苏A1001","奔驰","白色",1000,false),
            new MiniCar("苏A1002","宝马","黑色",800,false),
            new Bus("苏A1003","奥迪","蓝色",2200,false,35),
            new Bus("苏A1004","别克","红色",3000,false,46),
            new Turck("苏A1005","东风","绿色",1800,false,22),
            new Turck("苏A1006","解放","白色",2800,false,38)
    };

    //查看车辆信息
    private void show(){
        System.out.println("***************查看车辆****************");
        System.out.println("车牌号码\t车辆名称\t车辆颜色\t日租金\t车辆状态\t车辆类型\t座位数量\t载重吨位");
        for(Car car : cars){
            System.out.print(car.getNo()+"\t"+
                    car.getName()+"\t\t"+
                    car.getColor()+"\t\t"+
                    car.getRent()+"\t"+
                    (car.isStutus()?"已租":"可租")+"\t\t");
            if(car instanceof MiniCar){
                //判断是否是轿车
                System.out.print("轿车\t\t无\t\t无\n");
            }else if(car instanceof Bus){
                //判断是否是客车
                Bus bus = (Bus) car;
                System.out.print("客车\t\t"+bus.getSeatNum()+"\t\t无\n");
            }else if(car instanceof Turck){
                //判断是否是卡车
                Turck turck = (Turck) car;
                System.out.print("卡车\t\t无\t\t"+turck.getLoad()+"\n");
            }
        }
    }
    //租用车辆的方法
    private void rentCar(){
        System.out.println("***************租用车辆****************");
        System.out.print("请输入车牌号：");
        String no = input.next();
        //根据车牌号获取一辆车
        Car car = getCarByNo(no);
        if(car==null){
            System.out.println("您输入的车牌号不存在！！！");
            return;
        }
        if(car.isStutus()){
            System.out.println("该车辆已经租出！！！");
            return;
        }
        car.setStutus(true);    //将车辆的租用状态改成true
        System.out.print("请输入租用天数：");
        car.setDays(input.nextInt());
        System.out.println("车辆租用成功！");
    }
    //归还车辆的方法
    private void giveCar(){
        System.out.println("***************归还车辆****************");
        System.out.print("请输入车牌号：");
        String no = input.next();
        //根据车牌号获取一辆车
        Car car = getCarByNo(no);
        if(car==null){
            System.out.println("您输入的车牌号不存在！！！");
            return;
        }
        if(!car.isStutus()){
            System.out.println("该车辆无需归还！！！");
            return;
        }
        car.setStutus(false);  //将车辆的租用状态改成false
        // 调用计算总租金的方法
        double total = car.calcPrice();
        car.setDays(0);  //清空租用天数
        System.out.println("本次租车的总费用："+total);
    }
    // 根据车牌号返回一辆车
    private Car getCarByNo(String no){
        Car car = null;
        for(Car c : cars){
            if(c!=null && c.getNo().equals(no)){
                car = c;
                break;
            }
        }
        return  car;
    }

    // 主菜单方法
    public void menu(){
        while (true){
            System.out.println("************欢迎使用神州租车*************");
            System.out.println("1.查看车辆信息");
            System.out.println("2.租用车辆");
            System.out.println("3.归还车辆");
            System.out.println("0.退出系统");
            System.out.println("**************************************");
            System.out.print("请选择：");
            int no = input.nextInt();
            if(no==1){
                show();
            }else if(no==2){
                rentCar();
            }else if(no==3){
                giveCar();
            }else{
                System.out.println("成功退出系统！欢迎下次继续使用！");
                break;
            }
        }
    }
}
