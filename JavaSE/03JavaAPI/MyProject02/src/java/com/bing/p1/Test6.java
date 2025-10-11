package com.bing.p1;

/**
 * 自定义异常
 */
public class Test6 {
    public static void main(String[] args) {
        try {
            int ret = test(5);
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    private static int test(int index) throws MyException{
        int[] nums = {11,22,33,44,55};
        if(index>4){
            // 这里抛出一个自定义异常
            throw new MyException("索引不能超过4");
        }
        return nums[index];
    }
}
