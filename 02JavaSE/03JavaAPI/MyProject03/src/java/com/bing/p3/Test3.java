package com.bing.p3;

public class Test3 {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i=1;i<=50;i++){
                System.out.println(Thread.currentThread().getName()+" => "+i);
            }
        },"小明");
        Thread t2 = new Thread(()->{
            for (int i=1;i<=50;i++){
                System.out.println(Thread.currentThread().getName()+" => "+i);
                if(i==25){
                    try {
                        // join方法表示加塞
                        // 这里表示当前i==25时，线程1强行加塞，必须等到线程1执行完毕后，线程2继续执行后续操作
                        t1.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"小芳芳");
        t1.start();
        t2.start();
    }
}
