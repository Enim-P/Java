package com.bing.p6;

public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            while (true){
                try {
                    System.out.println("线程正在运行....");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        // 设置为守护线程，必须在线程启动之前设置
        // 守护线程，再其他线程全部执行完毕后，无论当前线程是否执行完毕，都会结束
        // IO操作不适合设置为守护线程，比如正一个线程正在下载文件，其他线程接收了，它可能还没有下载完成
        t.setDaemon(true);
        t.start();
        // 主线程
        for (int i=0;i<5;i++){
            System.out.println("主线程....");
            Thread.sleep(1000);
        }
    }
}
