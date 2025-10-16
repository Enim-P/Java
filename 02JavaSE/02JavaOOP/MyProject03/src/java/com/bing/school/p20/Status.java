package com.bing.school.p20;

/**
 * 学生的状态枚举
 */
public enum Status {
    // 枚举项，推荐是纯大写，如果你不习惯，至少首字母大写
    // 其实枚举就是一个固定结构的一组常量，常量可以写中文也可以写英文，推荐写英文（纯大写）
    // 可以在枚举类型中，通过成员变量的方式，给每个枚举选项添加一个描述
    /**
     * 学习
     */
    Study("学习"),
    /**
     * 睡觉
     */
    Sleep("睡觉"),
    /**
     * 吃饭
     */
    Eat("吃饭"),
    /**
     * 运动
     */
    Sport("运动");

    // 在枚举中写成员变量
    private final String name;

    // 返回成员变量name
    public String getName(){
        return this.name;
    }

    Status(String name){
        this.name = name;
    }
}
