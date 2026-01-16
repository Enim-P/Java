package com.bing.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * 阿里云OSS工具类
 */
@Component
public class AliOSSUtils {
    /*************阿里云OSS配置信息**************/
    /*
    // 存储空间的名称
    private String bucketName = "bing-3";
    // 存储区域地址
    private String endpoint = "https://oss-cn-hangzhou.aliyuncs.com";
    // 访问秘钥信息
    private String accessKeyId = "LTAI5tKkBaEfpyJGZogSXgv5";
    private String accessKeySecret = "vSzWXh7T6BAf95tz0D8R5AdMXHxY5h";
    */

    // @Value注解用于从外部配置中注入属性
    /*
    @Value("${aliyun.oss.bucketName}")
    private String bucketName;
    @Value("${aliyun.oss.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.accessKeyId}")
    private String accessKeyId;
    @Value("${aliyun.oss.accessKeySecret}")
    private String accessKeySecret;
    */

    // 注入aliOSS属性配置类
    @Resource
    AliOSSProperties aliOSSProperties;

    // 总结：@ConfigurationProperties 和 @Value
    // 相同点：都是用来从配置文件中注入属性
    // 不同点：@Value只能一个一个属性进行注入，@ConfigurationProperties可以批量注入多个属性

    // 上传方法
    public String upload(MultipartFile file) throws IOException {
        // 获取aliOSS相关参数
        String bucketName = aliOSSProperties.getBucketName();
        String endpoint = aliOSSProperties.getEndpoint();
        String accessKeyId = aliOSSProperties.getAccessKeyId();
        String accessKeySecret = aliOSSProperties.getAccessKeySecret();

        // 获取上传文件输入流
        InputStream inputStream = file.getInputStream();
        // 重命名文件
        String originalFilename = file.getOriginalFilename();
        String fileName = UUID.randomUUID().toString()+
                originalFilename.substring(originalFilename.lastIndexOf("."));

        // 上传文件到OSS
        OSS ossClient = new OSSClientBuilder().build(endpoint,accessKeyId,accessKeySecret);
        ossClient.putObject(bucketName,fileName,inputStream);

        // 文件访问路径
        // https://bing-3.oss-cn-hangzhou.aliyuncs.com/21341234213412341234123.jpg
        String url = endpoint.split("//")[0]+"//"+bucketName+"."+endpoint.split("//")[1]+"/"+fileName;

        // 关闭访问路径
        ossClient.shutdown();

        // 把上传到oss的文件访问路径返回
        return url;
    }
}
