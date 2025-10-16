package com.bing.p2;

public class Test3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println("线程1开始执行....");
            try {
                Thread.sleep(10000);  // 表示子线程做完所有事情需要的时间
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("线程1执行完毕....");
        });
        t1.start();
        System.out.println("主线程开始执行....");
        try {
            Thread.sleep(3000);   //表示主线做完所有的事情需要的时间
            t1.interrupt();   // 主线程事情做完了，希望子线程终止操作
            // 此时会引发InterruptedException异常，因为子线程目前处于休眠状态，不允许终止
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("主线程执行完毕....");

    }
}
