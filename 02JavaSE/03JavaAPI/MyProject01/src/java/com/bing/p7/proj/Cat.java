package com.bing.p7.proj;

import com.bing.p7.impl.Climb;

/**
 * 猫
 */
public class Cat extends Pet implements Climb {
    public Cat() {
    }

    public Cat(String name, String sex, int age) {
        super(name, sex, age);
    }

    @Override
    public void climb() {
        if(this.getHealth()>=60){
            System.out.println("猫咪"+this.getName()+"正在陪主人爬树...");
            this.setFeel(this.getFeel()+5);
            this.setHealth(this.getHealth()-8);
        }else{
            System.out.println("猫咪"+this.getName()+"太饿了，无法陪主人爬树...");
        }
    }

    @Override
    public void sayHi() {
        System.out.println(String.format("Hi！我是一只%s小猫，我叫%s，今年%s岁，我现在的健康值是%s，开心值是%s",
                this.getSex(),this.getName(),this.getAge(),this.getHealth(),this.getFeel()));
        //开心值-5
        this.setFeel(this.getFeel()-5);
        //健康值-5
        this.setHealth(this.getHealth()-5);
    }

    @Override
    public void eat() {
        if(this.getHealth()==100){
            System.out.println("不用喂食，已经吃饱了！");
        }else if (this.getHealth()>=70){
            System.out.println("猫咪"+this.getName()+"不是很饿，少投喂点！");
            this.setHealth(this.getHealth()+5);
        }else{
            System.out.println("给猫咪"+this.getName()+"喂食");
            // 健康值+8
            this.setHealth(this.getHealth()+8);
        }
    }

    @Override
    public void play() {
        System.out.println("主人："+this.getMaster()+"，正在陪他的猫咪玩耍...");
        this.climb();
    }
}
