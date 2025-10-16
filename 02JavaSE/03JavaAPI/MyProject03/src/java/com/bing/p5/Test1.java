package com.bing.p5;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        // ThreadLocal对象，用于创建线程的工作内存空间
        // 每个线程都可以使用该对象，存储一份自己多有工作内存空间
        // 注意：一个ThreadLocal对象在一个线程的内部，只能存储一份数据
        ThreadLocal<String> local = new ThreadLocal<>();

        Thread t1 = new Thread(()->{
            local.set("你好！我是线程1的数据");
            System.out.println(local.get());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(local.get());
        });

        Thread t2 = new Thread(()->{
            local.set("你好！我是线程2的数据");
            // 第二个线程中，无法获取第一个线程中的ThreadLocal数据
            System.out.println(local.get());
        });

        t1.start();
        Thread.sleep(1000);
        t2.start();
    }
}
