package com.bing.p2;

public class Test2 {
    static int value = 0;  //定义一个全局变量
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (int i=0;i<10000;i++){
                value++;
             }
            System.out.println("线程1执行完毕...");
        });
        Thread t2 = new Thread(()->{
            for (int i=0;i<10000;i++){
                value++;
            }
            System.out.println("线程2执行完毕...");
        });
        t1.start();
        t2.start();
        // 让主线程休眠1秒钟
        Thread.sleep(1000);
        // 通过观察发现，两个线程同时操作同一个变量，结果会出现问题
        System.out.println(value);
    }
}
