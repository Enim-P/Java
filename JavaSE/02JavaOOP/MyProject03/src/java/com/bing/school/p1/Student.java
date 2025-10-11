// package用于声明当前类所在的包
package com.bing.school.p1;

/**
 * 学生类
 */
public class Student {
    /*
        访问修饰符的作用：保护类 和 类内部的成员
        java语言中的访问修饰符：
        private：私有的，只能在类的内部访问
        不写访问修饰符：采用的是默认方式，当前类和同包下面的类可以访问
        protected：受保护访问权限，当前类、同包中的类可以访问、子类可以访问
        public：公共权限，所有的类都可以访问
    */
    // 学号采用私有访问修饰符
    private int no;
    // 姓名采用默认访问修饰符
    String name;
    // 性别采用公共访问修饰符
    public String sex;

    void printNo(){
        //私有成员只能在当前类中使用
        System.out.println("学号："+no);
    }
}
