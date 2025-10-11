package com.bing.p2;

public class Test5 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            System.out.println("子线程启动...");
            Thread.currentThread().suspend();   //暂停此线程
            System.out.println("子线程继续执行...");
        });
        t.start();

        System.out.println("主线程...");
        Thread.sleep(3000);
        t.resume();   //恢复暂停的子线程
        // 虽然这两个方法非常好用，但是它们也是弃用的方法
    }
}
