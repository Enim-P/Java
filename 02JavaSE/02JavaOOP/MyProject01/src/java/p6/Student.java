package p6;

/**
 * 学生类
 */
public class Student {
    void a(){
        System.out.println("a方法");
        // 方法可以相互调用
        b();
    }
    void b(){
        System.out.println("b方法");
        // 因为在a方法中已经调用了b方法，如果b方法再去调用a方法，就形成了递归（死循环）
        //a();
    }
    // 递归方法指的是：方法的内部调用了自己
    int calc(int num){
        // 累加1到num之间所有的数之和
        /*
        int total = 0;
        for(int i=1;i<=num;i++){
            total += i;
        }
        return total;
        */
        // 在递归算法中，一定要指定递归结束的条件
        if(num==0) return 0;
        return num + calc(num-1);
    }
}
