package com.bing.school.p17;

/**
 * 诺基亚手机
 */
public class Nokia extends Phone {
    public Nokia() {
    }

    public Nokia(String name, String color, String size) {
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
}
