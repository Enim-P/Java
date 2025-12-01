package com.bing.service;

import com.bing.annotation.MyAnnotation;
import org.springframework.stereotype.Component;

@Component
public class PCService {

    @MyAnnotation
    public void showPC(){
        System.out.println("联想笔记本电脑");
    }
}
