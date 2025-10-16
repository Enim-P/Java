package com.bing.p6;

public class Test1 {
    public static void main(String[] args) {
        // 实现一个定时器效果
        new TimerTask(()->{
            System.out.println("指定的时间后执行...");
        },2000).start();

        new TimerLoopTask(()->{
            System.out.println("每隔指定的时间后执行...");
        },3000).start();
    }

    // 定义一个定时器类（每隔指定的时间后执行）
    static class TimerLoopTask{
        // 线程对象（工作线程）
        Runnable task;
        // 定时时间
        long time;

        // 通过构造方法，给定时器的两个成员赋值
        public TimerLoopTask(Runnable runnable,long time){
            this.task = runnable;
            this.time = time;
        }

        // 开启定时器的方法
        public void start(){
            // 创建一个线程
            new Thread(()->{
                try {
                    while (true){
                        Thread.sleep(time);  //休眠指定的时间
                        task.run();          // 再运行我们的工作线程
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }

    // 定义一个定时器类（指定是时间后执行）
    static class TimerTask{
        // 线程对象（工作线程）
        Runnable task;
        // 定时时间
        long time;

        // 通过构造方法，给定时器的两个成员赋值
        public TimerTask(Runnable runnable,long time){
            this.task = runnable;
            this.time = time;
        }

        // 开启定时器的方法
        public void start(){
            // 创建一个线程
            new Thread(()->{
                try {
                    Thread.sleep(time);  //休眠指定的时间
                    task.run();          // 再运行我们的工作线程
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }
    }
}
