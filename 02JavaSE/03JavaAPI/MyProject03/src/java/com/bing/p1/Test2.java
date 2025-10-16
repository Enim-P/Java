package com.bing.p1;

public class Test2 {
    public static void main(String[] args) {
        // 创建子线程
        // 在java中创建子线程有两种方式：
        // 1.继承Thread类实现
        MyThread1 myThread1 = new MyThread1();
        // 通过start方法，启动线程
        myThread1.start();
        // 2.实现Runnable接口实现
        Thread myThread2 = new Thread(new MyThread2());
        myThread2.start();

        for (int i=1;i<=10;i++){
            System.out.println("=========主线程："+i);
        }
    }
}

// 方式一：继承Thread类实现多线程
class MyThread1 extends Thread{
    @Override
    public void run() {
        for (int i=1;i<=10;i++){
            System.out.println("子线程1："+i);
        }
    }
}

// 方式二：实现Runnable接口实现多线程
class MyThread2 implements Runnable{
    @Override
    public void run() {
        for (int i=1;i<=10;i++){
            System.out.println("子线程2："+i);
        }
    }
}

// 其实第一种方式本质上也是第二种，Thread父类的内部也是在实现Runnable接口
// 所以，快速实现一个多线程最直接的方法就是实现一个Runnable接口
