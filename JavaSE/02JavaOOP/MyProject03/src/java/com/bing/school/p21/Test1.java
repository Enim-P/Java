package com.bing.school.p21;

/**
 * 值类型包装类
 */
public class Test1 {
    public static void main(String[] args) {
        int num1 = 100;
        String s1 = "hello";
        // byte boolean short char int long float double这些都基本类型，也叫值类型
        // String是引用类型
        // 基本类型的变量，它就是一份数据，每个其他的操作
        // 所以java为了给基本类型增强，给每个基本类型添加了一个包装类类型
        Byte b1 = 'b';
        Boolean b2 = true;
        Short s = 100;
        Character c = '我';
        Integer i = 100;
        Long l = 100l;
        Float f = 55.5f;
        double d = 55.5;   //定义一个double类型的数据
        Double d2 = Double.valueOf(d);  //将double类型的数据转为的包装类对象
        Double d3 = 55.5;   //简化写法
        double d4 = d3.doubleValue();   //将Double类型的数据转给double类型的变量
        double d5 = d3;     //简化写法
        System.out.println("----------------------------");
        int n1 = 100;
        int n2 = 100;
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n1==n2);
        System.out.println("----------------------------");
        // 创建Integer对象
        Integer i2 = new Integer(100);
        Integer i3 = new Integer(100);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i2==i3);
        System.out.println("----------------------------");
        // Integer类型会缓存-128 ~ 127之间的数据，当前你重复定义这个区间的数据，它会将之前的地址返回
        Integer i4 = 127;
        Integer i5 = 127;
        System.out.println(i4==i5);
        System.out.println("----------------------------");
        Integer i6 = 300;
        Integer i7 = 300;
        System.out.println(i6==i7);
        // 所以，判断包装类型是否相等，不能使用==,而是要使用equals,用法就跟String很像了
        System.out.println(i6.equals(i7));
        // 也可以先返回值，再比较值
        System.out.println(i6.intValue() == i7.intValue());
    }
}
