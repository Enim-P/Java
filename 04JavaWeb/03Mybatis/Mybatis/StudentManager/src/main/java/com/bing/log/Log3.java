package com.bing.log;

import java.io.IOException;
import java.util.logging.*;

public class Log3 {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(Log2.class.getName());

        // 修改日志级别
        logger.setLevel(Level.CONFIG);
        // 不使用父日志处理器
        logger.setUseParentHandlers(false);
        // 使用自定义日志处理器
        // ConsoleHandler：控制台处理器
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.CONFIG);
        //handler.setFormatter(new XMLFormatter());   //以XML格式的方式打印
        logger.addHandler(handler);
        //FileHandler：文件处理器
        /*FileHandler fileHandler = new FileHandler("test.log");
        fileHandler.setLevel(Level.CONFIG);
        logger.addHandler(fileHandler);*/

        logger.log(Level.SEVERE,"严重的错误",new IOException("操作文件错误"));
        logger.log(Level.WARNING,"警告的内容");
        logger.log(Level.INFO,"普通的消息");  //默认级别
        // 默认情况下，低于普通级别的日志是不打印的，如果要打印，就需要修改日志级别
        logger.log(Level.CONFIG,"低于普通级别的消息");
    }
}
