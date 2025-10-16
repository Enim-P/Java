package p4;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        // 创建管理类对象
        Manager manager = new Manager();
        // 定义了两个int类型的变量
        int num1 = 100;
        int num2 = 200;
        // 注意：基本类型的方法参数，在传递时传的是值
        // 这里num1和num2只是将值复制了一份，传进了方法
        manager.fun1(num1,num2);
        System.out.println("num1="+num1+",num2="+num2);
        System.out.println("--------------");
        // 创建一个学生对象
        Student s = new Student();
        s.name = "小芳";
        s.age = 12;
        // 注意：引用类型的方法参数，在传递时传的是地址
        // 这里的s会将地址复制一份，传进去
        manager.fun2(s);
        System.out.println("姓名："+s.name);
        System.out.println("年龄："+s.age);
    }
}
