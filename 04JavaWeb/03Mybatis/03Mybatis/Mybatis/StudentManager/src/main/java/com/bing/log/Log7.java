package com.bing.log;

import lombok.extern.java.Log;

import java.io.IOException;

// lombok提供的@Log注解，它可以帮我们快速获取日志打印器对象
//@Log
@Log(topic = "强哥")
public class Log7 {
    public static void main(String[] args) throws IOException {
        System.out.println("Logger名称："+log.getName());
        log.info("我是一条消息日志");
    }
}
