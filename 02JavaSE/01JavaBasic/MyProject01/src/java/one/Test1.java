package one;

/**
* 测试类1
* */
// class 关键字，用于定义类，类名必须跟文件名相同，一个Java源文件中可以定义多个类,其他类不能使用public修饰
public class Test1 {
    //main方法是程序的入口方法，程序在运行的时候，会从main方法开始执行
    //一个类只能定一个main方法
    public static void main (String[] args ){
        System.out.println("Hello Java");
    }
}

class Hello{
    public static void main(String[] args){
        System.out.println("Hello");
    }
}
