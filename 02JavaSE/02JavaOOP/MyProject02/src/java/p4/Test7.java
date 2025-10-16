package p4;

import java.util.Arrays;

public class Test7 {
    public static void main(String[] args) {
        // 创建数组后，数组的每个空间里面都是有默认值的
        // int数组的默认值是0
        int[] arr1 = new int[5];
        // double数组的默认值是0.0
        double[] arr2 = new double[5];
        // String数组的默认值null，（其实所有引用类型数组的默认值都是null）
        String[] arr3 = new String[5];
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
    }
}
