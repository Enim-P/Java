package three;

/**
 * 练习
 */
public class test1 {
    public static void main(String[] args) {
        /*
            找出100以内所有的偶数，并输出

        * */
        int i = 0;
        while(i <= 100){
            if(i % 2 == 0)
                System.out.println(i);
                    i++;
        }
        System.out.println("------------");
        /*
        找出20世纪中所有的闰年并打印输出
        */
        int y = 1900; // 定义一个循环变量，表示20世纪的第一年
        while(y<2000){
            if(y%4 == 0 && y% 100 != 0 || y%400 ==0){
                System.out.println(y);
            }
            y++;
        }
        System.out.println("------------");
        /*
            找出三位数里面所有的水仙花数
        */
        int n = 100;
        while(n <=999){
            // 获取三位数中的百位 十位 个位
            int bw = n / 100 ;
            int sw = n % 100 / 10 ;
            int gw = n % 10 ;
            if((int)Math.pow(bw,3)+(int)Math.pow(sw,3)+(int)Math.pow(gw,3) == n){
                System.out.println(n);
            }
                    n++;
        }
        System.out.println("------------");
        /*

         */
    }
}
