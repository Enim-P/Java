package one;
/**
 * 测试类4
 * */
public class Test4 {
    public static void main(String[] args) {
        int a = 100;
        int b = 200;
        // 待做标记
        // TODO 实现两个变量的值互换，待完成
        // 将a和b的值互换
        // 这里需要借助一个中间变量c来实现
          int c;
          c = a;  //将a的值传给c
          a = b;  //将b的值传给a
          b = c;  //将c的值传给b
        System.out.println("a=" + a);
        System.out.println("b=" + b);
    }
}
