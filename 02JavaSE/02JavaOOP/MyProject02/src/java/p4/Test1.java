package p4;

public class Test1 {
    public static void main(String[] args) {
        //数组
        //需求：存储5名学生的成绩，这个时候最佳的方式就是使用数组
        //变量：就是在内存中开辟一个指定类型的存储空间
        //数组：就是在内存中开辟一个连续的指定类型的存储空间
        // 数组是引用类型，所以这里创建数组必须要new
        int[] nums = new int [5];   //推荐语法
        int nums2[] = new int[5];   //不推荐语法
        //数组定义好了之后，就可以往数组的空间中存放数据了
        //通过数组的下标(索引)往指定的数组空间中存放数据，数组的下标从0开始，最大下标是长度-1
        nums[0] = 60;
        nums[1] = 70;
        nums[2] = 80;
        nums[3] = 90;
        nums[4] = 100;
        // 如果超出了数组的下标存储数据，会引发数组下标溢出异常
        //nums[5] = 120;
        // 获取数组中存储的数据，还是通过数组的下标
        System.out.println(nums[2]);
        // 直接输出数组对象，返回的是数组的地址
        System.out.println(nums);
        // length属性返回的是数组的长度
        System.out.println(nums.length);
    }
}
