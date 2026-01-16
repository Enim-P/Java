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
 * 成绩实体类
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "成绩实体类")
@TableName("result")
public class Result {
    @ApiModelProperty("成绩Id")
    @TableId(type = IdType.AUTO)
    private Integer resultId;
    @ApiModelProperty("学生学号")
    private String studentNo;
    @ApiModelProperty("课程Id")
    private Integer subjectId;
    @ApiModelProperty("学生成绩")
    private Integer studentResult;
    @ApiModelProperty("考试日期")
    private LocalDateTime examDate;

    // 成绩所属学生
    @ApiModelProperty("成绩所属学生")
    @TableField(exist = false)   // 从生成的sql语句中排除
    private Student student;
    // 成绩所属课程
    @ApiModelProperty("成绩所属课程")
    @TableField(exist = false)   // 从生成的sql语句中排除
    private Subject subject;
}
