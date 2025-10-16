package p4;

import java.util.Arrays;
import java.util.Random;

public class Test6 {
    public static void main(String[] args) {
        // 随机生成一组双色球中奖号码，并保存到数组中
        // 1到6组的号码是0到32之间不重复的随机数，第7组号码是0到16之间的随机数
        // 创建是一个随机数对象
        Random r = new Random();
        // 定义个长度为7的数组
        int[] nums = new int[7];
        // 使用循环生成前6组号码
        for(int i=0;i<nums.length-1;i++){
            nums[i] = r.nextInt(33);
            // 判断当前生成的号码，之前是不是已经生成过了
            for(int j=0;j<i;j++){
                // 如果之前生成过
                if(nums[i]==nums[j]){
                    i--;  // i先减1，等一下还会再加1
                    break;  //直接跳出内层循环
                }
            }
        }
        // 生成最后1组号码
        nums[nums.length-1] = r.nextInt(17);
        System.out.println(Arrays.toString(nums));
    }
}
