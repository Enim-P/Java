package com.bing.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 用户操作日志实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperateLog {
    private Integer id;   // 标识列
    private Integer operateUser;  // 操作用户的Id
    private LocalDateTime operateTime;  //操作时间
    private String className;   // 操作的类
    private String methodName;  // 操作的方法
    private String methodParams;   // 方法参数
    private String returnValue;  // 方法返回值
    private Long costTime;  // 操作时间
}
