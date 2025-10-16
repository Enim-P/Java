package com.bing.p7.proj;

import com.bing.p7.impl.Swim;

/**
 * 狗
 */
public class Dog extends Pet implements Swim {
    public Dog() {
    }

    public Dog(String name, String sex, int age) {
        super(name, sex, age);
    }

    @Override
    public void sayHi() {
        System.out.println(String.format("Hi！我是一只%s小狗，我叫%s，今年%s岁，我现在的健康值是%s，开心值是%s",
                this.getSex(),this.getName(),this.getAge(),this.getHealth(),this.getFeel()));
        //开心值-3
        this.setFeel(this.getFeel()-3);
        //健康值-3
        this.setHealth(this.getHealth()-3);
    }

    @Override
    public void eat() {
        if(this.getHealth()==100){
            System.out.println("不用喂食，已经吃饱了！");
        }else if (this.getHealth()>=80){
            System.out.println("狗狗"+this.getName()+"不是很饿，少投喂点！");
            this.setHealth(this.getHealth()+3);
        }else{
            System.out.println("给狗狗"+this.getName()+"喂食");
            // 健康值+5
            this.setHealth(this.getHealth()+5);
        }
    }

    @Override
    public void play() {
        System.out.println("主人："+this.getMaster()+"，正在陪他的狗狗玩耍...");
        this.swim();
    }

    @Override
    public void swim() {
        if(this.getHealth()>=60){
            System.out.println("狗狗"+this.getName()+"正在陪主人游泳...");
            this.setFeel(this.getFeel()+5);
            this.setHealth(this.getHealth()-5);
        }else{
            System.out.println("狗狗"+this.getName()+"太饿了，无法陪主人游泳...");
        }
    }
}
