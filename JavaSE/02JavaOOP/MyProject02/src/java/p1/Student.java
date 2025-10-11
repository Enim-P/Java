package p1;

// 在java语言中，不能定义静态类
public class Student {
    String name;
    // static关键字定义静态成员，静态成员属于类不属于某个对象
    // 类的静态成员，该类的所有对象都可以访问
    // 类的静态成员在内存中只有一份，当前类自己和它产生的所有的对象共享这一份空间
    static String address;
    static void sayHi(){
        System.out.println("你好！我是学生");
    }
    // 通常情况下，一些工具方法，我们会定义成静态方法
    // 比如：判断一个年份是不是闰年，判断一个字符串的长度格式是不是不规范等等
}
