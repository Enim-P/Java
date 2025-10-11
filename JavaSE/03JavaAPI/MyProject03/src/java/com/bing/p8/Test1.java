package com.bing.p8;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Test1 {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 通过类创建对应类型的对象
        Student s1 = new Student();
        s1.test();
        System.out.println("---------------------");
        // 先拿到类的Class对象
        Class<Student> clazz = Student.class;
        // 再通过Class对象创建对应类型的对象
        Student s2 = clazz.newInstance();
        s2.test();
        System.out.println("---------------------");
        Teacher t1 = new Teacher("张三");
        t1.test();
        System.out.println("---------------------");
        Class<Teacher> clazz2 = Teacher.class;
        // newInstance方法，是通过无参构造来创建对象的，此时Teacher没有无参构造
        // 而且无参构造不能是私有的，否则会引发对应的两个异常
        // Teacher t2 = clazz2.newInstance();
        // 先获取带指定参数的构造方法，再通过该构造方法创建对象
        Teacher t2 = clazz2.getConstructor(String.class).newInstance("李四");
        t2.test();
        // 如果还是想要通过无参的构造方法来创建对象，又该如何实现？
        // 1.拿到无参构造方法对象
        // 有两个方法：getConstructor 和 getDeclaredConstructor
        // getConstructor无法拿到私有构造方法
        // getDeclaredConstructor可以拿到私有构造方法
        Constructor<Teacher> constructor = clazz2.getDeclaredConstructor();
        // 2.修改它的访问权限
        constructor.setAccessible(true);
        // 3.再通过拿到后并修改了访问权限的构造方法对象，创建对应类型的对象
        Teacher t3 = constructor.newInstance();
        t3.test();
    }
}
