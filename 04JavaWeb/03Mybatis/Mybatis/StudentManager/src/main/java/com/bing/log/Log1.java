package com.bing.log;

import java.util.logging.Logger;

public class Log1 {
    public static void main(String[] args) {
        // 之前我都是直接通过System.out.println的方式打印信息
        System.out.println("我是普通的日志");
        // 其实JDK还提供了一个自带的日志框架，可以使用这个日志框架帮我们打印一些日志信息
        // 获取日志打印器对象
        Logger logger = Logger.getLogger(Log1.class.getName());
        // 使用日志打印器输出日志信息，包含日志的时间，发生的位置等信息
        // 通过日志输出结果会更加规范
        logger.info("我是普通的日志");
    }
}
