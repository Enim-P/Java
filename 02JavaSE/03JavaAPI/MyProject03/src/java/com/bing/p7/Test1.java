package com.bing.p7;


import java.util.ArrayList;

public class Test1 {
    public static void main(String[] args) {
        // 正常情况下，我们需要通过类创建成对象，再去操作对象身上的成员
        // 反射指的是，直接通过类反射出类身上有哪些成员（比如：属性，方法），然后跳过通过创建对象方式就可以操作这些成员
        // 所以反射式比较危险的，因为它可以直接修改类中的成员，而且访问修饰符在反射面前甚至都不起作用（所以反射要慎用）

        // java虚拟机在运行的时候，会将程序中用到的类以Class类型对象的形式加载到内存中
        // Class类型就是所有类的对象类型
        // 比如：这里我们创建了一个Student类型的对象
        // java虚拟机就根据Student对应的Class类型的对象，克隆了一个对象
        // 可以理解成：java虚拟机在运行的时候，会先把所有类型的样板间在内存中盖好，之后创建指定类型对象，就根据这个样板间克隆
        /*Student student = new Student();
        Student student1 = new Student();
        String str = "abc";*/

        // 查看一下java中有哪些类的加载器
        // 查看当前类的加载类
        // Test1.class获取当前类的Class对象（可以理解成获取类在内存中的样板间）
        // 观察发现，自定义类的加载器是AppClassLoader
        System.out.println(Test1.class.getClassLoader());
        // 获取父加载器，观察发现是ExtClassLoader
        System.out.println(Test1.class.getClassLoader().getParent());
        // 获取父加载器的父加载，返回null，其实是BootstarpClassLoader
        // 注意：BootstarpClassLoader是根加载器，是用C++写的，java语句获取不到
        // 其实java的虚拟机也就是JVM是用C++写的
        System.out.println(Test1.class.getClassLoader().getParent().getParent());
        // 系统类都是用BootstarpClassLoader加载的
        System.out.println(String.class.getClassLoader());
        System.out.println(ArrayList.class.getClassLoader());
    }
}
