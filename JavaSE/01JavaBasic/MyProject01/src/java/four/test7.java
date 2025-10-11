package four;

/**
 * 练习
 */
public class test7 {
    public static void main(String[] args) {
        /*
            找出100以内所有的质数
            质数：只能被1和自身整除的数，除去1
        */
        // 外层循环控制数的范围
        for(int i = 2;i<=100;i++){
            int count = 0;
            // 内层循环控制比较数的范围
            for(int j =1;j<=i;j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            // 如果count=2就是质数
            if(count==2){
                System.out.println(i);
                }
            }
        }
    }

