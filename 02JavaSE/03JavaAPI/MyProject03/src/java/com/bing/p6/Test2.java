package com.bing.p6;

import java.util.Timer;
import java.util.TimerTask;

public class Test2 {
    public static void main(String[] args) {
        // 使用系统自带的定时器
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("3秒钟后执行...");
                // 需要手动调用cancel方法，结束定时器
                timer.cancel();
            }
        },3000);
    }
}
