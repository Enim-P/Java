package com.bing.log;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Log6 {
    public static void main(String[] args) throws IOException {
        // 获取日志管理器
        LogManager manager = LogManager.getLogManager();
        // 读取日志的配置文件
        manager.readConfiguration(Log6.class.getClassLoader().getResourceAsStream("Logging.properties"));
        // 获取日志打印器对象
        Logger logger = Logger.getLogger(Log6.class.getName());
        logger.config("我是一条日志信息");
    }
}
