package com.bing.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(description = "日志实体类")
@TableName("operate_log")
public class OperateLog {
    @ApiModelProperty("标识列")
    @TableId(type = IdType.AUTO)
    private Integer id;   // 标识列
    @ApiModelProperty("操作用户的Id")
    @TableField("operate_user")
    private Integer operateUser;  // 操作用户的Id
    @ApiModelProperty("操作时间")
    @TableField("operate_time")
    private LocalDateTime operateTime;  //操作时间
    @ApiModelProperty("操作的类")
    @TableField("class_name")
    private String className;   // 操作的类
    @ApiModelProperty("操作的方法")
    @TableField("method_name")
    private String methodName;  // 操作的方法
    @ApiModelProperty("方法参数")
    @TableField("method_params")
    private String methodParams;   // 方法参数
    @ApiModelProperty("方法返回值")
    @TableField("return_value")
    private String returnValue;  // 方法返回值
    @ApiModelProperty("操作时间")
    @TableField("cost_time")
    private Long costTime;  // 操作时间
}
