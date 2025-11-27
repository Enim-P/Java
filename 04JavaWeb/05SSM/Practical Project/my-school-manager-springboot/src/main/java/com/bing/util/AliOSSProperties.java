package com.bing.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 阿里云OSS属性配置类
 */
@Data
@Component
// 配置属性注解，自动将aliyun.oss下面的子节点属性值注入给当前类中对应名称的字段
@ConfigurationProperties("aliyun.oss")
public class AliOSSProperties {
    private String bucketName;
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
}

// @ConfigurationProperties注意的作用，就是自动将配置文件中配置的数据注入给指定的的实体类中的字段
