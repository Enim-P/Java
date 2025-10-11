package com.bing.school.p16;

/**
 * 火箭
 */
public class Rocket implements Flay {

    @Override
    public void flay(int height) {
        System.out.println("火箭正在"+height+"米的高空飞行...");
    }
}
