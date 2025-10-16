package com.bing.p2;

public class Test4 {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println("线程1开始执行....");
            while (true){
                //System.out.println("线程1..");
                // 判断当前线程是否是中断状态
                if(Thread.currentThread().isInterrupted()){
                    //break;
                    System.out.println("发现中断信号，复位，继续运行...");
                    Thread.interrupted();  //复位中断
                }
            }
            //System.out.println("线程1执行完毕....");
        });
        t1.start();
        System.out.println("主线程开始执行....");
        try {
            Thread.sleep(3000);
            t1.interrupt();   // 提前中断子线程
            //t1.stop();  // 注意：stop()方法，也是中断线程，该方法已经被弃用了，因为该方法是强行中断线程
            //interrupt()方法，由线程自己确定何时中断，因为可能此时正在做一些关键的操作，比如：文件流才读了半个字符
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("主线程执行完毕....");
    }
}
