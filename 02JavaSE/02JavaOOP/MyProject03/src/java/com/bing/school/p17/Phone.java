package com.bing.school.p17;

/**
 * 手机
 */
public abstract class Phone {
    private String name;
    private String color;
    private String size;

    public Phone() {
    }

    public Phone(String name, String color, String size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    // 打电话
    public abstract void call();
    // 发短信
    public abstract void message();
}
