package four;
/**
 * 练习
 */
public class test3 {
    public static void main(String[] args) {
        //
        /*

            *
            **
            ***
            ****
            *****
         */
        for(int i = 1; i<=5; i++){
            for(int j = 1; j<=i;j++){
                        System.out.print("*");
                }
                System.out.println(); // 换行
            }
        System.out.println("----------------------");
        /*
            * *
            * ***
            * *****
            * *******
            * *********
         */
        for(int i = 1; i<=5;i++){
                for(int j = 1;j<=i*2-1;j++ ){
                    System.out.print("*");
                }
                System.out.println();
            }
        System.out.println("----------------------");
        /*
           *****
           ****
           ***
           **
           *
         */
        // 外层控制行数
        for(int i=1;i<=5;i++){
            // 内层控制每行列数
            for(int j =1;j<=6-i;j++){
                System.out.print("*");
            }
            System.out.println();
            }
        System.out.println("----------------------");

            /*
                        *
                       ***
                      *****
                     *******
                    *********
             */
        for(int i = 1;i<=5;i++){
            // 内层第一个for打印前面的空格
                for(int j = 4;j-i>=0;j--){
                    System.out.print(" ");
                }
                // 内层第二个for打印图形的数量
                    for(int n = 1; n<=i*2-1;n++){
                        System.out.print("*");
                    }
            System.out.println();
            }
        System.out.println("----------------------");

        }
    }

