package com.bing.p1;

import java.io.File;

/**
 * 理解什么是异常
 */
public class Test1 {
    public static void main(String[] args) {
        // 异常：就是程序在运行的时候发生了我们没有考虑到的情况，而出现的jvm报错
        // 比如这里的除数设置为0，在运行的时候，就会发生异常
        /*int ret = test(100,0);
        System.out.println(ret);*/

        // 比如这里的数组下标越界，在运行的时候，就会发生异常
        /*int[] nums = new int[5];
        nums[5] = 100;*/
        // 异常又分：运行时异常 和 编译时异常
        // 上面两种情况的异常都是运行时异常，就是程序在运行到这段代码时，才会引发异常

        // 什么是编译时异常，就是代码写完就报错，必须进行异常处理，否则编译不通过
        // 比如：文件流的相关操作
        /*File file = new File("abc.txt");
        file.createNewFile();*/

        // 错误：程序的异常可以处理，但是错误是无法处理的，程序一旦发生错误，一定是致命的，jvm是没有办法处理的，比如内存溢出
        // 异常是Exception，错误是Error
        /*int[] arr = new int[Integer.MAX_VALUE];
        System.out.println(arr[0]);*/


    }

    private static int test(int a,int b){
        return a / b;
    }

}
