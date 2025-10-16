package p3;

/**
 * 学生类
 */
public class Student {
    // 计算方法
    int calc(int num1,int num2,String type){
        /*
        int total = 0;   //定义一个结果
        switch (type){
            case "+":
                total = num1 + num2;
                break;
            case "-":
                total = num1 - num2;
                break;
            case "*":
                total = num1 *  num2;
                break;
            case "/":
                total = num1 / num2;
                break;
            case "%":
                total = num1 % num2;
                break;
            default:
                System.out.println("操作符错误！");
                break;
        }
        return total;   //返回结果
        */
        switch (type){
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 *  num2;
            case "/":
                return num1 / num2;
            case "%":
                return num1 % num2;
            default:
                System.out.println("操作符错误！");
                return 0;
        }
    }

    // 判断是否是闰年
    boolean isLeepYear(int year){
        return year%4==0 && year%100!=0 || year % 400==0;
    }

    // 打印等腰三角形
    void printSjx(int num){
        // 判断num不能小于2
        if(num<2){
            System.out.println("三角形行数不能小于2");
            return;  //直接返回
        }
        //外层循环控制行数
        for(int i=1;i<=num;i++){
            //补空格
            for(int j=num-1;j>=i;j--){
                System.out.print(" ");
            }
            //内层循环控制每行列数
            for(int j=1;j<=i*2-1;j++){
                System.out.print("*");
            }
            System.out.println();   //换行
        }
    }

}
