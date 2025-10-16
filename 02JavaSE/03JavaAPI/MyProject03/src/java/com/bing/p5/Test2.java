package com.bing.p5;

public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        ThreadLocal<Double> local = new ThreadLocal<>();
        Thread t1 = new Thread(()->{
            local.set(Double.valueOf(1000));
            System.out.println("我的工资："+local.get());
            new Thread(()->{
                // 子线程也无法获取父线程中的ThreadLocal数据
                System.out.println("我父亲的工资："+local.get());
            }).start();
        });
        t1.start();
        Thread.sleep(2000);
        System.out.println("---------------");
        // InheritableThreadLocal对象，用于创建子线程能获取到的ThreadLocal数据
        ThreadLocal<String> local2 = new InheritableThreadLocal<>();
        Thread t2 = new Thread(()->{
            local2.set("10000");
            System.out.println("我的工资："+local2.get());
            new Thread(()->{
                System.out.println("我父亲的工资："+local2.get());
            }).start();
        });
        t2.start();
    }

}
