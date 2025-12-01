package com.bing;

import com.bing3.config.Bing3Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

// 如果bean对象放置在启动类做在包的外面，必须要通过@ComponentScan扫描它的位置
@ComponentScan({"com.bing","com.bing2"})
@Import({Bing3Config.class})   // 导入指定的类，一般用于导入配置类，导入普通类也行
@SpringBootApplication
public class SpringBoot6Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot6Application.class, args);
    }

}
