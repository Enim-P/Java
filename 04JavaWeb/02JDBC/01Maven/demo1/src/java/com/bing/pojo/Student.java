package com.bing.pojo;

import lombok.*;

/**
 * 学生类
 */
// lombok提供的各种注解，可以方便我们快速生成实体类的方法
//@Getter   // 生成Get方法
//@Setter   // 生成Set方法
//@ToString    // 生成toString方法
@Data   // @Data = @Getter + @Setter + @ToString + @RequiredArgsConstructor + @EqualsAndHashCode
@NoArgsConstructor    // 生成无参构造
@AllArgsConstructor   // 生成有参构造
public class Student {
    private int no;
    private String name;
    private String hobby;
}
