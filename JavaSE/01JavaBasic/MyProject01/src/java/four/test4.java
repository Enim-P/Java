package four;
/**
 * 练习2
 */
public class test4 {
    public static void main(String[] args) {
        /*
            打印一个九九乘法表
            1*1=1
            2*1=2 2*2=4

        */
        for(int i = 1; i<=9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + "*" + j + "=" + i * j + " ");
            }
            System.out.println();
        }
            System.out.println("--------------------------");
            /*
                    1
                   121
                  12321
                 1234321
                123454321
             */
            for(int i = 1; i<=5; i++) {
                for (int j = 5; j - i >= 0; j--) {
                    System.out.print(" ");
                }
                for (int n = 1; n <= i; n++) {
                    System.out.print(n);
                }
                for (int m =(i-1);m>0;m--) {
                    System.out.print(m);
                }
                System.out.println();
            }
            System.out.println("-----------------");

        }
    }

