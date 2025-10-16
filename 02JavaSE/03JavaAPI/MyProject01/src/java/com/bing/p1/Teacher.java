package com.bing.p1;

public class Teacher {
    // 使用泛型方法，在调用方法时再确定方法的参数和返回值类型
    public <T> T test1(T num){
        return num;
    }

    // 方法重载可以解决问题，但是一个方法的相同业务需要写多次，代码会非常冗余
    /*public static String test1(String num){
        return num + num;
    }*/
}
