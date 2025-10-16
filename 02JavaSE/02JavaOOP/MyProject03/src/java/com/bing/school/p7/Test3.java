package com.bing.school.p7;

public class Test3 {
    public static void main(String[] args) {
        Child child = new Child();
        // 子类继承了父类的所有成员
        child.sayHi();
        System.out.println("-----------------");

        // 将Child类型的对象，转为了Parent类型
        Parent parent = child;
        // sayHi方法，被子类重写了，转为成父类类型后，也访问不到父类的原始方法
        parent.sayHi();
    }
}
