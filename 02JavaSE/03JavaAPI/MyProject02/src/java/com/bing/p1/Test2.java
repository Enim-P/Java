package com.bing.p1;

/**
 * 运行时异常
 */
public class Test2 {
    public static void main(String[] args) {
        int[] nums = new int [5];
        // 将对数组指定空间赋值的代码放置到try中，如果数组下标越界，程序会调整到catch中执行，而不是终止
        try{
            nums[5] = 100;  // 这一行代码有可能会发生异常
        }catch (ArrayIndexOutOfBoundsException e){
            // catth里面可以不做任何处理
            System.out.println("对数组指定空间赋值时发生异常！");
            // 通过异常对象的getMessage方法，返回异常消息
            System.out.println(e.getMessage());
            // 通过异常对象的printStackTrace方法，打印出现异常的所有堆栈信息
            e.printStackTrace();
        }

        // 程序一旦发生异常，后面的程序就不会再往下执行了，
        // 所以运行时异常需要程序员有丰富的开发经验，对有可能会发生的异常做提前处理
        // 将有可能会引发异常的代码，用try保护起来，如果真的发生了一次，通过catch来做处理
        System.out.println("程序继续往下执行.....");
    }
}
