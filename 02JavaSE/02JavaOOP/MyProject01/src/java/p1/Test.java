package p1;

/**
 * 测试类
 */
public class Test {
    // main方法，是程序的入口方法
    public static void main(String[] args) {
        // 在java中使用class关键字定义类，在类中可以定义成员（属性、方法）
        // 根据我们定义的类，可以创建无数个对象
        // 类只是一个定义，一种抽象，我们规定了一种类型，有哪些属性，哪些方法
        // 而对象是一个具体，我们明确了对象的具体属性值和方法的具体行为

        // 在java中创建对象要使用new关键字
        Student s1 = new Student();
        // 成员变量有初始值，基本类型初始值是0，引用类型的初始值是null
        System.out.println(s1.no);
        System.out.println(s1.name);
        System.out.println(s1.age);
        System.out.println(s1.sex);
        System.out.println("--------------------");
        // 通过对象名.属性的方式访问属性，通过这种方式可以给属性赋值
        s1.no = 1001;
        s1.name = "张三";
        s1.age = 20;
        s1.sex = "男";
        System.out.println(s1.no);
        System.out.println(s1.name);
        System.out.println(s1.age);
        System.out.println(s1.sex);
        System.out.println("--------------------");
        // 通过对象名.方法名()的方式，调用对象的方法，调用方法会执行方法中定义的代码
        s1.study();
        System.out.println("--------------------");
        // 再定义一个学生对象
        Student s2 = new Student();
        s2.no = 1001;
        s2.name = "张三";
        s2.age = 20;
        s2.sex = "男";
        s2.study();
        System.out.println(s1==s2);
        System.out.println("--------------------");
        // 再定义一个学生对象，直接将之前的学生对象赋值给它
        Student s3 = s1;  // 此时s3只是一个引用，它指向了s1的实际存储空间
        s3.study();
        System.out.println(s1==s3);
        System.out.println("--------------------");
        /*
            总结：
            在内存中，有两种常用的内存空间，栈空间和堆空间
            基本类型采用栈空间存储数据（int\double\char...）栈空间是有大小的，比如int是32位
            引用类型采用堆空间存储数据（String\class\数组...）堆空间是没有大小的，需要多少空间开辟多少空间
            注意：引用类型在创建的时候，也需要申请一个栈空间，用于存储堆的地址
            比如：
            int i = 100，它只是在内存中申请一个int类型栈空间，然后再空间中存储100
            String s = "hello"，它会在内存中申请一个堆空间，在里面存储"hello",还要在审请一个栈空间存储堆的地址
            栈空间其实是内存提前开辟好的存储空间，可以帮助我们快速存储数据
        */
        s3.name = "李四";
        s3.sex = "女";
        // 注意s3更改的就是s1的数据
        s1.study();
    }
}
