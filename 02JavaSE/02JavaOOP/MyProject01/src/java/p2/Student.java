package p2;

/**
 * 学生类
 */
public class Student {
    // 方法

    // 带参数的方法，在方法的()里面定义方法的参数，此时的参数叫做方法的形参（也叫形式参数）
    void fun1(int a,double b,String c){
        System.out.println(a+b+c);
    }

    // void表示方法不需要返回任何结果
    // 此时的方法需要返回一个String
    String fun2(int a,int b){
        // 带返回值的方法，必须要使用return关键字返回结果
        return a+"+"+b+"="+(a+b);
    }

    void fun3(int no){
        // 在void方法中，也可以使用return提前结束方法的执行
        // 注意：此时return不能返回任何结果
        if(no%2==0) {
            return;
        }
        System.out.println(no);
    }

    void fun4(){
        for(int i=1;i<=5;i++){
            if(i==3){
                //break;   //跳出整个循环，还要执行方法中其他部分代码
                return;    //跳出整个方法，肯定也跳出循环了
            }
            System.out.println(i+"好好学习");
        }
        System.out.println("end");
    }
}
