package com.bing.p1;

/**
 * 异常抛出
 */
public class Test5 {
    public static void main(String[] args) throws Exception {
        try {
            int ret = test(100,0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("程序继续往下执行...");
        System.out.println("----------------------");
        // 都已经到最后一层了，如果还是不想处理，继续往上层抛，此时的上层就是java虚拟机
        int ret2 = fun2(5);
        System.out.println(ret2);
        System.out.println("程序继续往下执行....");
    }

    // 方法的内部，有抛出异常的语句，那么在定义方法的时候就要声明抛出的异常是什么异常
    private static int test(int a,int b) throws Exception {
        if(b==0){
            // throw用于抛出异常
            throw new Exception("除数不能为0！");
        }
        return a / b;
    }

    private static int fun1(int index) throws Exception{
        // 如果不想再当前方法中处理异常，进行在方法声明中向上层抛出异常
        return fun2(index);
    }

    private static int fun2(int index) throws Exception{
        int[] nums = {11,22,33,44,55};
        if(index>4){
            throw new Exception("索引不能超过4");
        }
        return nums[index];
    }

}
