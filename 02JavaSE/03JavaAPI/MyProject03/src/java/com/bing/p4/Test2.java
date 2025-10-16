package com.bing.p4;

public class Test2 {
    static int value = 0;  //定义一个全局变量
    // synchronized直接加在方法上，给方法上锁，多个线程同一时间只允许一个线程调用该方法
    static synchronized void add(){
        value++;
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (int i=0;i<10000;i++){
                add();
            }
            System.out.println("线程1执行完毕...");
        });
        Thread t2 = new Thread(()->{
            for (int i=0;i<10000;i++){
                add();
            }
            System.out.println("线程2执行完毕...");
        });
        t1.start();
        t2.start();
        // 让主线程休眠1秒钟
        Thread.sleep(1000);
        System.out.println(value);
    }
}
