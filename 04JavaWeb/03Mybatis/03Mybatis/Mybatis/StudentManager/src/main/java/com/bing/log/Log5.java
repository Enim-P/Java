package com.bing.log;

import java.util.logging.Level;

public class Log5 {
    public static void main(String[] args) {
        // log方法的第一个参数需要设置日志的级别
        LogUtil.logger.log(Level.SEVERE,"我是测试消息1...");
        LogUtil.logger.log(Level.WARNING, "我是测试消息2...");
        LogUtil.logger.log(Level.INFO, "我是测试消息3...");
        System.out.println("------------------");
        // 还可以直接调用指定日志级别的方法
        LogUtil.logger.severe("错误信息");
        LogUtil.logger.warning("警告信息");
        LogUtil.logger.info("消息信息");
    }
}
