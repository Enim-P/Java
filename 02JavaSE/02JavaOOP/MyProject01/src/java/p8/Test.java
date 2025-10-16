package p8;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        // 创学生对象
        Student s1 = new Student();
        // 对对象的属性赋值
        s1.no = 1001;
        s1.name = "张三";
        s1.age = 22;
        s1.sex = "男";
        s1.sayHi();
        // 通过调用带参数的构造方法，在创建对象的同时就对对象的属性赋值
        Student s2 = new Student(1002,"李四",23,"女");
        s2.sayHi();
        Student s3 = new Student(1003,"王五",24,"男");
        // 重新修改对象的属性值
        s3.name = "王杰";
        s3.sayHi();
    }
}
