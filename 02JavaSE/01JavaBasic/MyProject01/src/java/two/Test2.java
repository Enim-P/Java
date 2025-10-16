package two;
/**
 * if语句
 * */
public class Test2 {
    public static void main(String[] args) {
        int score = 95;
        //boolean isok = score > 90;
        // if选择结构，用于判断条件，满足条件执行对应的操作
        //（）里面定义判断条件，{}里面定义执行操作
        if (score > 90){
            System.out.println("优秀");
        }else{
            System.out.println("还行");
        }
        //if语句可以单独使用，也可以跟else语句组合使用，当if的条件不成立时，执行else的代码
        //注意：else不能单独使用
        System.out.println("结束");
    }
}
