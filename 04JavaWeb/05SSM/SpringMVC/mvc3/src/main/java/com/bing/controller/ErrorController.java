package com.bing.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 处理错误的控制器
@ControllerAdvice
public class ErrorController {

    // 只要发生异常，通常都会走当前控制器处理
    @ExceptionHandler(Exception.class)
    public String error(Exception e){
        e.printStackTrace();
        return "static/error.html";
    }
}
