package com.bing.school.p15;

/**
 * Six接口的实现类
 */
public class SixImpl implements Six {
    // 重写Six接口的抽象方法
    @Override
    public String fun(int num1, int num2) {
        return num1+"*"+num2+"="+(num1*num2);
    }
}
