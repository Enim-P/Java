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
 * 学生实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "学生实体类")
@TableName("student")
public class Student {
    @ApiModelProperty("学号")
    @TableId(type = IdType.INPUT)
    private String studentNo;
    @ApiModelProperty("密码")
    private String loginPwd;
    @ApiModelProperty("学生姓名")
    private String studentName;
    @ApiModelProperty("性别")
    private String sex;
    @ApiModelProperty("年级Id")
    private Integer gradeId;
    @ApiModelProperty("电话")
    private String phone;
    @ApiModelProperty("地址")
    private String address;
    @ApiModelProperty("生日")
    private LocalDateTime bornDate;
    @ApiModelProperty("邮箱")
    private String email;
    @ApiModelProperty("身份证号")
    private String identityCard;

    // 学生所属年级
    @ApiModelProperty("学生所属年级")
    @TableField(exist = false)   // 从生成的sql语句中排除
    private Grade grade;
}
