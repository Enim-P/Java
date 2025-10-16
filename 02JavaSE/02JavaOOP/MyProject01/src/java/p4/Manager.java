package p4;

/**
 * 管理类
 */
public class Manager {
    // 参数类型是基本类型
    void fun1(int a,int b){
        System.out.println("a="+a+",b="+b);
        a = 1000;
        b = 2000;
        System.out.println("a="+a+",b="+b);
    }

    // 参数类型是引用类型
    void fun2(Student stu){
        stu.name = "小明";
        stu.age = 15;
    }
}
