package com.bing.school.p13;

public class Test {
    public static void main(String[] args) {
        //创建了一个悍马车对象
        HanMa hanMa = new HanMa();
        hanMa.run(150);
        hanMa.msg();
        hanMa.gun();
        System.out.println("-----------------");
        // 是符合is a关系的，悍马车是一辆车
        Car car = new HanMa();
        car.run(100);
        // 实现接口，也符合is a关系，此时的悍马车它就是一件武器
        // 所谓面向接口编程，就是这个意思，就是先定义功能，再实现功能
        Weapon weapon = new HanMa();
        weapon.gun();
        // 此时悍马车也是一个卫星装备
        Satellite satellite = new HanMa();
        satellite.msg();
        // 注意：由于是用父类或接口类型接收子类对象，所以只能使用到父类定义的行为

    }
}
