package p7;

/**
 * 二维数组
 */
public class Test1 {
    public static void main(String[] args) {
        // 一维数组
        int[] nums = new int[3];
        nums[0] = 100;
        nums[1] = 200;
        nums[2] = 300;
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        System.out.println("------------------");
        int[][] nums2 = new int[3][4];
        //给二维数组的空间赋值，需要同时提供两个下标（一维下标 和 二维下标）
        nums2[0][0] = 100;
        nums2[1][3] = 300;
        nums2[2][2] = 200;
        //获取二维数组中的数据，用法给赋值时一样的
        System.out.println(nums2[1][3]);
        //如果只提供一维下标，获取的是对应的二维的地址，二维数组就是多个一维数组叠加的结构
        System.out.println(nums2[2]);
        System.out.println("------------------");
        //获取长度
        System.out.println(nums2.length);
        System.out.println(nums2[0].length);
        System.out.println("------------------");
        //遍历整个数组
        //遍历一维
        for (int i=0;i<nums2.length;i++){
            //遍历一维对应的二维
            for(int j=0;j<nums2[i].length;j++){
                System.out.println(nums2[i][j]);
            }
        }
        System.out.println("------------------");
        //如果使用foreach
        for(int[] arr : nums2){
            for(int ret : arr){
                System.out.println(ret);
            }
        }
    }
}
