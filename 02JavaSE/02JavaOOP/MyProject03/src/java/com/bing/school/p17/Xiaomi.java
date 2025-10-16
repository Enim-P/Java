package com.bing.school.p17;

public class Xiaomi extends Phone {
    public Xiaomi() {
    }

    public Xiaomi(String name, String color, String size) {
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

    public void movie(){
        System.out.println(this.getName()+"可以看视频...");
    }
}
