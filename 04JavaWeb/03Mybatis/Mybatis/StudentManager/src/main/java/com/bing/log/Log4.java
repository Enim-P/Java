package com.bing.log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

public class Log4 {
    // 自定义日志的输出格式
    public static void main(String[] args) {
        // 返回日期处理器对象
        Logger logger = Logger.getLogger(Log4.class.getName());
        // 关闭父日志处理器
        logger.setUseParentHandlers(false);

        //为了让颜色变回普通的颜色，通过代码块在初始化时将输出流设定为System.out
        ConsoleHandler handler = new ConsoleHandler(){{
            setOutputStream(System.out);
        }};
        //创建匿名内部类实现自定义的格式
        handler.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                String time = format.format(new Date(record.getMillis()));  //格式化日志时间
                String level = record.getLevel().getName();  // 获取日志级别名称
                // String level = record.getLevel().getLocalizedName();   // 获取本地化名称（语言跟随系统）
                String thread = String.format("%10s", Thread.currentThread().getName());  //线程名称（做了格式化处理，留出10格空间）
                long threadID = record.getThreadID();   //线程ID
                String className = String.format("%-20s", record.getSourceClassName());  //发送日志的类名
                String msg = record.getMessage();   //日志消息

                //\033[33m作为颜色代码，30~37都有对应的颜色，38是没有颜色，IDEA能显示，但是某些地方可能不支持
                return "\033[38m" + time + "  \033[33m" + level + " \033[35m" + threadID
                        + "\033[38m --- [" + thread + "] \033[36m" + className + "\033[38m : " + msg + "\n";
            }
        });
        logger.addHandler(handler);

        logger.log(Level.SEVERE,"我是测试消息1...");
        logger.log(Level.WARNING, "我是测试消息2...");
        logger.log(Level.INFO, "我是测试消息3...");
    }
}
