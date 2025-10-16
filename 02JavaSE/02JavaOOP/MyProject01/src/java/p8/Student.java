package p8;

public class Student {
    // 构造方法是创建对象时调用的方法，该方法的方法名跟类名相同，无返回值类型
    // 在类中，如果没有定义构造方法，编译器会帮我们定义一个无参数的构造方法
    // 如果我们自己定义了构造方法，此时编译器就不会再帮我们定义了

    // 成员变量不赋值时，有默认值，值类型是0，引用类型是null
    int no = 100;
    String name;
    int age;
    String sex;

    // 构造方法也支持重载，通常我们在定义带参数构造方法时，要补上无参的构造方法
    Student(){
    }
    // 通过带参数的构造方法，对成员变量赋值
    Student(int no,String name,int age,String sex){
        // 成员变量的初始值，在调用构造方法之前执行
        System.out.println(this.no);
        // 当前方法的的形参跟成员变量同名时，
        // 在方法内部优先级更高的是形参，这里使用this.成员变量
        // this关键字指向的就是当前对象
        this.no = no;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    void sayHi(){
        System.out.println("学号："+no+"，姓名："+name+"，年龄："+age+"，性别："+sex);
    }
}
