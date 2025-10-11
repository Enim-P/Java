package com.bing.p4;

public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        // Object类有三个方法：notify、notifyAll、wait
        // 这三个方法需要配合synchronized来使用，也就是要再同步代码块中才能使用

        // 这里我们创建了一个Object对象，作为下面两个线程中同步代码块的锁来使用
        Object o = new Object();

        //准备两个线程
        Thread t1 = new Thread(()->{
            synchronized (o){
                try {
                    System.out.println("线程1开始执行....");
                    // 对象的wait方法会暂时使当前线程进入等待状态
                    o.wait();
                    System.out.println("线程1执行完成....");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread t2 = new Thread(()->{
            synchronized (o){
                System.out.println("开始唤醒线程1...");
                // notify方法，随机唤醒一个处于等待状态的线程
                // notifyAll方法，唤醒所有处于等待状态的线程
                o.notifyAll();
                // 虽然唤醒了线程1，但是依然需要等待这里的锁释放完了，才会去执行上面的线程
                for(int i=1;i<=50;i++){
                    System.out.println("线程2-----》"+i);
                }
            }
        });
        t1.start();
        Thread.sleep(1000);
        t2.start();
    }
}
