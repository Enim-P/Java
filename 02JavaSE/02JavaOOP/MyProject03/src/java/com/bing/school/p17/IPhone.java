package com.bing.school.p17;

/**
 * 苹果手机
 */
public class IPhone extends Phone {
    public IPhone() {
    }

    public IPhone(String name, String color, String size) {
        super(name, color, size);
    }

    @Override
    public void call() {
        System.out.println(this.getName()+"正在打电话...");
    }

    @Override
    public void message() {
        System.out.println(this.getName()+"正在发短信...");
    }

    public void play(){
        System.out.println(this.getName()+"可以打游戏...");
    }
}
