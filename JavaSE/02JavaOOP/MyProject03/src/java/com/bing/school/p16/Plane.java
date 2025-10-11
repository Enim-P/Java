package com.bing.school.p16;

/**
 * 飞机
 */
public class Plane implements Flay {
    @Override
    public void flay(int height) {
        System.out.println("飞机正在"+height+"米的高空飞行...");
    }
}
