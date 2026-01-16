package com.bing.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 用户实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "用户实体类")   // Swagger的注解，用于表示实体类的含义
public class Admin {
    @ApiModelProperty("用户Id")       // Swagger的注解，用于表示实体类属性的含义
    private Integer id;
    @ApiModelProperty("登录名")
    private String loginId;
    @ApiModelProperty("登录密码")
    private String loginPwd;
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("性别")
    private String sex;
    @ApiModelProperty("电话")
    private String phone;
    @ApiModelProperty("类型")
    private String type;
    @ApiModelProperty("头像")
    private String photo;
    @ApiModelProperty("入职日期")
    private LocalDateTime inDate;
}
