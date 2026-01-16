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

/**
 * 课程实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "课程实体类")
@TableName("subject")
public class Subject {
    @ApiModelProperty("课程Id")
    @TableId(type = IdType.AUTO)
    private Integer subjectId;
    @ApiModelProperty("课程名称")
    private String subjectName;
    @ApiModelProperty("课时")
    private Integer classHour;
    @ApiModelProperty("年级Id")
    private Integer gradeId;

    // 课程所属年级
    @ApiModelProperty("课程所属年级")
    @TableField(exist = false)   // 从生成的sql语句中排除
    private Grade grade;
}
