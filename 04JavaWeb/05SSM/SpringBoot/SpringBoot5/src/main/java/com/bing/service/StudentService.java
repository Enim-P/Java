package com.bing.service;

import org.springframework.stereotype.Component;

@Component
public class StudentService {

    public String sayHi(){
        for (int i=1;i<=10;i++){
            System.out.println("你好！我是一名学生！");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // 手动引发异常
            /*if(i==5){
                throw new RuntimeException("出错了！");
            }*/
        }
        return "我每天学习很辛苦！";
    }

    public String sayHello(){
        for (int i=1;i<=10;i++){
            System.out.println("你好！我是一名三好学生！");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return "我每天学习非常辛苦！";
    }
}
