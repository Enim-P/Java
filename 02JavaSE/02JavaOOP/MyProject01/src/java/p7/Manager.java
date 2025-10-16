package p7;

/**
 * 方法重载
 */
public class Manager {
    /*
        在一个类中，方法名相同，方法的参数列表不同，这样的方法就是方法重载
        参数列表不同，可以是参数的数量不同，也可以是参数的类型不同
        注意：方法重装跟方法的返回值类型无关
    */

    // 加法运算的方法
    int sum(int num1,int num2){
        return num1 + num2;
    }

    double sum(double num1,double num2){
        return num1 + num2;
    }
}
