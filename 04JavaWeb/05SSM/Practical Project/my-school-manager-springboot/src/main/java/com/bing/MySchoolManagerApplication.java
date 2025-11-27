package com.bing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//@ServletComponentScan   // 开启Servlet组件支持（就会扫描当前项目中定义所有Servlet，当然也包括Filter）
@SpringBootApplication  // SpringBoot启动类
public class MySchoolManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MySchoolManagerApplication.class, args);
    }

}
