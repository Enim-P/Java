package com.bing.p3;

public class Test1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
           for (int i=1;i<=10;i++){
               System.out.println(Thread.currentThread().getName()+" => "+i);
           }
        },"小明");
        Thread t2 = new Thread(()->{
            for (int i=1;i<=10;i++){
                System.out.println(Thread.currentThread().getName()+" => "+i);
            }
        },"小芳");
        Thread t3 = new Thread(()->{
            for (int i=1;i<=10;i++){
                System.out.println(Thread.currentThread().getName()+" => "+i);
            }
        },"小天");
        // 通常情况，每个线程抢占CPU资源的概率是相同的
        t1.start();
        t2.start();
        // setPriority方法，用于设置当前线程抢到CPU资源的概率
        // 传的值越大，概率越高，传值范围是（1-10）
        // 只能说是概率更高一点，不是一定的
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.start();
    }
}
