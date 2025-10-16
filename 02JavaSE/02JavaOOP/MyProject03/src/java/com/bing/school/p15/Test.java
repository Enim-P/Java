package com.bing.school.p15;

/**
 * 使用lambda表达式实现接口
 */
public class Test {
    public static void main(String[] args) {
        // 实现无参无返回值的接口方法
        One one = ()->{
            System.out.println("哈哈哈");
        };
        one.fun();
        // 如果方法体只有一条语句，{}可以省略
        One one2 = ()-> System.out.println("呵呵呵");
        one2.fun();
        System.out.println("------------------------");
        //()里面定义的是参数，注意：不需要数据类型，这个参数只是一个占位符，可以随便定义
        Two two = (num)->{
            System.out.println(num*num);
        };
        two.fun(100);
        //只有一个参数时，()可以省略
        Two two2 = num-> System.out.println(num*num);
        two2.fun(10);
        System.out.println("------------------------");
        //有多个参数时，()不能省略，方法体只有一条语句时{}继续可以省略
        Three three = (num1,num2)-> System.out.println(num1+"+"+num2+"="+(num1+num2));;
        three.fun(10,20);
        System.out.println("------------------------");
        Four four = ()->{
            return "哈哈哈哈哈哈";
        };
        System.out.println(four.fun());
        // 如果方法体只有一条返回语句，在省略{}的同时，return关键字必须省略
        // 注意：方法没有参数时，()必须不能省略
        Four four2 = ()->"呵呵呵呵呵呵";
        System.out.println(four2.fun());
        System.out.println("------------------------");
        // 带一参，带返回值的简写
        Five five = num -> num+"*"+num+"="+(num*num);
        System.out.println(five.fun(100));
        System.out.println("------------------------");
        // 1.0写法：必须要先定义实现类，那么这个类毫无意义
        Six six1 = new SixImpl();
        System.out.println(six1.fun(100,200));
        // 2.0写法：使用匿名内部类
        Six six2 = new Six() {
            @Override
            public String fun(int num1, int num2) {
                return num1+"*"+num2+"="+(num1*num2);
            }
        };
        System.out.println(six2.fun(100,200));
        // 3.0写法：lambda表达式
        Six six3 = (num1,num2)->{
            return num1+"*"+num2+"="+(num1*num2);
        };
        System.out.println(six3.fun(100,200));
        // 3.0的简化写法
        Six six4 = (num1,num2) -> num1+"*"+num2+"="+(num1*num2);
        System.out.println(six4.fun(10,20));
        // 本质上都是第一种写法，只是后面的写法由编译器帮我们定义临时的实现类了
    }
}
