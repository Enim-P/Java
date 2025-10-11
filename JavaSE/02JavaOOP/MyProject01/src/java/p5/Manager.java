package p5;

/**
 * 管理类
 */
public class Manager {
    /**
     * 打印菱形
     * @param num 菱形行数
     */
    void printLx(int num){
        if(num%2==0){
            System.out.println("菱形的行数必是奇数！");
            return;
        }
        int shang = num / 2 + 1;  //上面多少行
        int xia = num / 2;        //下面多少行
        // 先打印上面
        for(int i=1;i<=shang;i++){
            for(int j=shang-i;j>0;j--){
                System.out.print(" ");
            }
            for( int j=1;j<=i*2-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        // 再打印下面
        for(int i=xia;i>=1;i--){
            for(int j=xia-i;j>=0;j--){
                System.out.print(" ");
            }
            for( int j=1;j<=i*2-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 打印空心菱形
     * @param num 菱形行数
     */
    void pringKxLx(int num){
        if(num%2==0){
            System.out.println("菱形的行数必是奇数！");
            return;
        }
        int shang = num / 2 + 1;  //上面多少行
        int xia = num / 2;        //下面多少行
        // 先打印上面
        for(int i=1;i<=shang;i++){
            for(int j=shang-i;j>0;j--){
                System.out.print(" ");
            }
            for( int j=1;j<=i*2-1;j++){
                if(j==1 || j==i*2-1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        // 再打印下面
        for(int i=xia;i>=1;i--){
            for(int j=xia-i;j>=0;j--){
                System.out.print(" ");
            }
            for( int j=1;j<=i*2-1;j++){
                if(j==1 || j==i*2-1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
