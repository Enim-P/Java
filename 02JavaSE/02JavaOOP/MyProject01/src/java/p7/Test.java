package p7;

/**
 * 测试类
 */
public class Test {
    public static void main(String[] args) {
        Manager m = new Manager();
        int i1 = 100;
        int i2 = 200;
        int ret1 = m.sum(i1,i2);
        System.out.println(ret1);
        double d1 = 55.55;
        double d2 = 66.66;
        double ret2 = m.sum(d1,d2);
        System.out.println(ret2);
        System.out.println("----------------------------");
        // println方法，就是一个方法重载
        // 当我们传入需要在控制台输出的内容时，传入的是什么类型，就调用指定参数类型的println方法
        System.out.println(100);
        System.out.println(55.55);
        System.out.println('男');
        System.out.println("你好吗");
        System.out.println(true);
        System.out.println(m);  //打印对象，输出的是对象的地址
    }
}
