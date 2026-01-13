package com.bing.project2.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户实体类
 */
@Data   // 自动生成get set toString方法
@NoArgsConstructor  // 自动生成无参构造方法
@AllArgsConstructor // 自动生成带全参的构造方法
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String password;
    private Integer age;
    private String tel;
}
