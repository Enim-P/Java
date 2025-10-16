package com.bing.p1;

public class Test4 {
    public static void main(String[] args) {
        // 开启一个线程计算1-10000之间所有偶数之和
        // 再开启一个线程计算1-10000之间所有奇数之和
        // 主线程计算1-10000之间所有能被5整除的数之和
        Thread t1 = new Thread(()->{
           int sum = 0;
           for(int i=1;i<=10000;i++){
               if(i%2==0){
                   sum+=i;
               }
           }
            System.out.println("1-10000之间的偶数之和："+sum);
        });
        Thread t2 = new Thread(()->{
            int sum = 0;
            for(int i=1;i<=10000;i++){
                if(i%2!=0){
                    sum+=i;
                }
            }
            System.out.println("1-10000之间的奇数之和："+sum);
        });
        t1.start();  //线程1启动
        t2.start();  //线程2启动
        // 下面是主线程
        int sum = 0;
        for(int i=1;i<=10000;i++){
            if(i%5==0){
                sum+=i;
            }
        }
        System.out.println("1-10000之间的能被5整除的数之和："+sum);
        /*
            线程的执行流程：
            1.创建线程
            2.调用start()方法，启动线程，启动后就进入到的就绪状态，开始抢占CPU资源
            3.抢到CPU资源后才运行，就是执行线程操作的代码
            4.在运行的过程中线程可能会中断（比如调用了sleep()方法，让线程休眠一段时间）
            5.此时线程又会回到就绪状态，等待下一次抢占CPU资源
            6.线程的所有操作执行完，后手动停止线程，线程就会回到终止状态（结束）
        */
    }
}
