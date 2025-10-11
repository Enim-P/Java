package com.bing.p4;

public class Test1 {
    static int value = 0;  //定义一个全局变量
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (int i=0;i<10000;i++){
                // 使用synchronized给代码块加锁
                // ()里面放置的是锁，{}里面是代码块
                // 锁就是一个对象，但是上多把锁的时候，必须是同一个对象
                // 这个对象可以手动new一个任意对象，也可以直接使用当前类的class对象
                // 因为当前类的class对象不管在哪里使用，都是同一个对象
                synchronized (Test1.class){
                    value++;
                }
            }
            System.out.println("线程1执行完毕...");
        });
        Thread t2 = new Thread(()->{
            for (int i=0;i<10000;i++){
                synchronized (Test1.class){
                    value++;
                }
            }
            System.out.println("线程2执行完毕...");
        });
        t1.start();
        t2.start();
        // 让主线程休眠1秒钟
        Thread.sleep(1000);
        // 通过观察发现，两个线程同时操作同一个变量，结果会出现问题
        // 解决的办法是上锁，其中一个线程在操作数据时，给数据上了一把锁，另一个线程就无法同时更新数据了
        System.out.println(value);
    }
}
