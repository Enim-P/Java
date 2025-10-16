package com.bing.p1;

/**
 * 多重异常捕获的第二种写法
 */
public class Test8 {
    public static void main(String[] args) {
        // 这个是第一种写法：每个异常通过一个catch来处理
        try{

        }catch (IndexOutOfBoundsException e){

        }catch (NullPointerException e){

        }catch (Exception e){

        }
        System.out.println("-------");
        try{

        }catch (IndexOutOfBoundsException | NullPointerException e){
            // 可以选择一些子类使用一个catch一起处理，每个异常类型使用|隔开
        }catch (Exception e){

        }
        System.out.println("-------");
        // 其实大部分情况下直接使用父类Exception处理就完事了
        try{

        }catch (Exception e){

        }
    }
}
