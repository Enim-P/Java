package com.bing.p1;

/**
 * finally语句
 */
public class Test7 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 0;
        try{
            // try中一旦发生异常，程序会离开跳转到catch执行，try剩下的代码就不会再执行了
            int ret = num1 / num2;
            System.out.println("结果："+ret);
        }catch (Exception e){
            System.out.println("发生异常...");
        }finally {
            // 无论try中是否发生异常，finally都会在最后执行
            // 所以finally语句特别适合作为文件流的释放操作
            System.out.println("finally....");
        }
        System.out.println("程序继续往下执行....");

        // try语句不能单独使用，必须要结合catch和finally期中的一个使用
        try{
            int ret = num1 / num2;
            System.out.println("结果："+ret);
        } finally {
            System.out.println("finally2....");
        }
        System.out.println("程序继续往下执行....");
    }
}
