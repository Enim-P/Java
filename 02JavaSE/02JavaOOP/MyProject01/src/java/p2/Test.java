package p2;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        // 创建学生对象
        Student s = new Student();
        int a = 100;
        double b = 55.55;
        String c = "hello";
        // 调用学生对象的方法
        // 因为方法需要参数，所以在调用方法时，需要传入具体的值
        // 而这里在调用方法时传递的参数就是实参（带有实际值的参数）
        s.fun1(a,b,c);
        // 在调用带参数的方法时，可以直接传入对应值，不需要实现先定义好变量
        s.fun1(100,55.55,"hello");
        System.out.println("-------------------------");
        // 调用带返回值的方法，需要接收返回值
        // 这里定义了一个String类型的变量却接收方法的返回值
        String s1 = s.fun2(100,200);
        System.out.println(s1);
        // 也可以直接输出方法返回的结果
        System.out.println(s.fun2(1000,2000));
        System.out.println("-------------------------");
        s.fun3(20);
        s.fun3(21);
        System.out.println("-------------------------");
        s.fun4();
    }
}
