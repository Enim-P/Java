package com.bing.school.p19;

public class Test {
    public static void main(String[] args) {
        One one1 = new One() {
            @Override
            public int sum(int num1, int num2) {
                return num1 + num2;
            }
        };
        System.out.println(one1.sum(100,200));
        System.out.println("------------");
        One one2 = (num1, num2) -> {
            return num1 + num2;
        };
        System.out.println(one2.sum(100,200));
        System.out.println("------------");
        One one3 = (num1,num2)->{
            // 方法的主体还是自己写，只是方法的计算过程调用之前写的
            return Math.sum(num1,num2);
        };
        System.out.println(one3.sum(100,200));
        System.out.println("------------");
        // 因为One接口的实现方法，跟Math类里面的静态方法sum一模一样，所以可以直接使用方法引用，使用Math里面的sum方法
        // 方法引用的语法是：类型::静态方法 或 对象::实例方法
        // 它就表示直接使用Math里面的sum方法，作为我的One接口的实现方法，因为它满足条件
        One one4 = Math::sum;
        System.out.println(one4.sum(100,200));
        System.out.println("------------");
        One one5 = new Student()::js;
        System.out.println(one5.sum(100,200));
        System.out.println("------------");
        // 这里直接使用jdk中Integer类型定义好的sum方法，作为当前接口的实现方法
        // 所以，你对jdk中的方法了解的越深入，方法引用对你的帮助越大
        One one6 = Integer::sum;
        System.out.println(one6.sum(100,200));
    }
}
