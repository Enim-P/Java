package com.bing.p1;

public class Test3 {
    public static void main(String[] args) {
        // 获取当前线程的名字
        System.out.println("我是线程："+Thread.currentThread().getName());
        // 创建子线程，可以通过匿名内部类来实现，也可以直接通过lambdl来简写
        Thread thread1 = new Thread(()->{
            System.out.println("我是线程："+Thread.currentThread().getName());
            for (int i=1;i<=10;i++){
                System.out.println("子线程------>"+i);
            }
        },"小明");   // 第二个参数手动设置线程的名字，线程的名字默认是：Thread-编号
        thread1.start();
        for (int i=1;i<=10;i++){
            System.out.println("=========主线程："+i);
        }
    }
}
