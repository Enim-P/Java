package p1;

// 在java中定义类，类名的首字母通常要大写
/**
 * 学生类
 */
public class Student {
    // 在类中直接定义的变量，是成员变量，成员变量就是类的属性
    int no;
    String name;
    int age;
    String sex;

    // 类中的方法，定义了类的行为
    void study() {
        System.out.println("我是"+name+"，学号"+no+"，年龄"+age+"，性别"+sex+"，我每天都要学习...");
    }
}
