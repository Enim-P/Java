package p1;

public class School {
    // private用于定义私有访问权限的成员
    private int a;
    private int b;
    private int c;
    private static int d;
    // 在静态代码块中对静态成员变量赋值
    // 静态代码块整个生命周期中，只会执行一次，在该类第一次被访问的是执行
    static {
        System.out.println("这是一个静态代码块...");
        d = 400;
    }
    // 在类中可以直接定义一个代码块
    {
        System.out.println("这是一个代码块...");
        // c是内部的安全数据，不能交给外部赋值
        this.c = 300;
    }
    School(){
        System.out.println("执行构造方法...");
    }
    School(int a,int b){
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        // 在创建对象时，代码块在构造方法之前执行
        School s1 = new School();
        School s2 = new School();
        School s3 = new School(100,200);
    }
}
