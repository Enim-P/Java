package com.bing.p1;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

public class Test1 {
    //应用程序、进程、线程的关系
    //一个应用程序至少包含一个进程，一个进程至少包含一个线程
    //可以将进程当成工厂里面的车间，而线程就是车间里面的生产线，一个车间可以有多个生产线，也就是线程是具体干活的
    public static void main(String[] args) {
        // java是多线程的开发语法，main方法就是一个主线程，可以在主线程中开启子线程
        // 其实main方法在运行的时候，已经帮我们开起了JVM底层的很线程
        // System.out.println("main");
        // 查看JVM开启了哪些线程
        ThreadMXBean bean = ManagementFactory.getThreadMXBean();
        long[] ids = bean.getAllThreadIds();
        ThreadInfo[] infos = bean.getThreadInfo(ids);
        for(ThreadInfo info : infos){
            // 查看线程的名字
            System.out.println(info.getThreadName());
        }
        // 这里线程是JVM底层的，我们不需要关系，我们只需要关心main方法是主线程就行了
    }
}
