package com.bing.service;

import com.bing.annotation.MyAnnotation;
import org.springframework.stereotype.Component;

@Component
public class PhoneService {

    // 给当前方法添加我们的自定义注解
    @MyAnnotation
    public void showPhone(){
        System.out.println("华为P80手机");
    }
}
