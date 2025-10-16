package com.bing.p2;

public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        // main方法就是主线程
        System.out.println("A");
        Thread.sleep(1000);  //让主线程休眠1000毫秒
        System.out.println("B");
        Thread.sleep(1000);
        System.out.println("C");
        Thread.sleep(1000);
        System.out.println("D");
        System.out.println("--------------------------");
        Thread t1 = new Thread(()->{
            // 获取当前线程对象
            Thread me = Thread.currentThread();
            for(int i=0;i<=50;i++){
                System.out.println("输出："+i);
                if(i==20){
                    // 终止当前线程
                    me.stop();
                }
            }
            System.out.println("for结束了.....");
        });
        t1.start();
    }
}
