package com.bing.p1;

// 自定义异常必须要继承Exception
public class MyException extends Exception {
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}
