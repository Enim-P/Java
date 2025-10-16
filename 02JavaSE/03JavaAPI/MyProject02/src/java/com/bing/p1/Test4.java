package com.bing.p1;

import java.io.File;
import java.io.IOException;

/**
 * 多路捕获异常
 */
public class Test4 {
    public static void main(String[] args) {
        try{
            int num1 = 10;
            int num2 = 0;
            int ret = num1 / num2;
            int[] nums = new int[5];
            nums[5] = 100;
            File file = new File("my.txt");
            file.createNewFile();
        }catch (ArithmeticException e){
            System.out.println("发生算术异常...");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("发送数组索引越界异常...");
        }catch (IOException e){
            System.out.println("发生IO异常...");
        } catch (Exception e){
            // e.printStackTrace();
            // 不管发生什么异常，统一使用异常的父类Exception来处理
            // 也可以使用多catch对所有异常的情况做保护，注意：子类写上面，父类写下面
            System.out.println("发送异常...");
        }
        System.out.println("程序继续往下执行...");
    }
}
