package com.bing.school.p17;

public class Test {
    public static void main(String[] args) {
        // 调用工厂类的生产手机的方法
        Phone phone1 = Factory.createPhone("iphone17 Pro","白色","1280*420","苹果");
        Phone phone2 = Factory.createPhone("小米15","红色","1110*550","小米");
        phone1.call();
        phone1.message();
        phone2.call();
        phone2.message();
        System.out.println("--------");
        //如果要是子类具体的成员，需要强转会具体的子类
        ((IPhone)phone1).play();
        ((Xiaomi)phone2).movie();
    }
}
