package com.bing.p7.proj;

/**
 * 宠物类
 */
public abstract class Pet {
    //名称
    private String name;
    //性别
    private String sex;
    //年龄
    private int age;
    //健康值
    private int health;
    //开心值
    private int feel;
    //主人姓名
    private String master;


    // 宠物打招呼的方法
    public abstract void sayHi();
    // 喂食方法
    public abstract void eat();
    // 玩耍方法
    public abstract void play();

    public Pet(){}

    public Pet(String name,String sex,int age){
        this.name = name;
        this.sex = sex;
        this.age = age;
        // 新宠物的健康值和开心值都是80分
        this.health = 80;
        this.feel = 80;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        // 健康值的上限是100
        if(health>100) health = 100;
        this.health = health;
    }

    public int getFeel() {
        return feel;
    }

    public void setFeel(int feel) {
        // 开心值的上限是100
        if(feel>100) feel = 100;
        this.feel = feel;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }
}
