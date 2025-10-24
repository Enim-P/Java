package com.bing.log;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log2 {
    public static void main(String[] args) {
        // 获取日志打印器对象
        Logger logger = Logger.getLogger(Log2.class.getName());
        // JUL日志级别分为7个级别：SEVERE、WARNING、INFO
        // CONFIG、FINE、FINER、FINEST
        logger.log(Level.SEVERE,"严重的错误",new IOException("操作文件错误"));
        logger.log(Level.WARNING,"警告的内容");
        logger.log(Level.INFO,"普通的消息");  //默认级别
        // 默认情况下，低于普通级别的日志是不打印的，如果要打印，就需要修改日志级别
        logger.log(Level.CONFIG,"低于普通级别的消息");
    }
}
