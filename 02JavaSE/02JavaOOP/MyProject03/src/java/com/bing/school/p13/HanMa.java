package com.bing.school.p13;

/**
 * 悍马车
 */
// 这里使用悍马车去继承汽车，此时他们的关系是：HanMa is a Car
// java中的类是单继承，但是可以多实现，通过implements关键字实现接口的功能
public class HanMa extends Car implements Weapon,Satellite  {
    public HanMa() {
    }

    public HanMa(String no, String type) {
        super(no, type);
    }

    // 重新父类的行驶方法
    @Override
    public void run(int speed) {
        System.out.println("一辆悍马车正在以"+speed+"的速度行驶...");
    }

    //重写卫星接口发送消息的方法
    @Override
    public void msg() {
        System.out.println("悍马车正在呼叫总部支援...");
    }

    //重新武器接口的机枪方法
    @Override
    public void gun() {
        System.out.println("悍马车正在使用机枪防御...");
    }
}
