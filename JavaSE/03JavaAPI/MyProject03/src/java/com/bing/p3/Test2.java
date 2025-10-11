package com.bing.p3;

public class Test2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i=1;i<=50;i++){
                System.out.println(Thread.currentThread().getName()+" => "+i);
                if(i%5==0){
                    // yield方法，用于线程让位
                    // 这里表示当i能被5整除是，线程1如果抢到了CPU资源，让给线程2
                    Thread.yield();
                }
            }
        },"小明");
        Thread t2 = new Thread(()->{
            for (int i=1;i<=50;i++){
                System.out.println(Thread.currentThread().getName()+" => "+i);
            }
        },"小芳芳");
        t1.start();
        t2.start();
    }
}
