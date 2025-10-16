package two;
import java.util.Scanner;
/**
 * 练习
 */
public class test11 {
    /*请输入是否是会员，输入y是会员，输入n不是会员
            请输入消费金额
    会员：消费打8折，满100元打6折
    非会员：消费满200元打9折，不满200元不打折
            最后输出本次实际消费金额*/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入是否为会员：（输入y是会员，输入n不是会员）");
        String a = input.next();
        System.out.print("请输入消费金额：");
        int xf = input.nextInt();
        if(a.equals("y")){
            if(xf>=100){
                System.out.println("本次实际消费金额:" + 0.6*xf);
            }else{
                System.out.println("本次实际消费金额:" + 0.8*xf);
            }
        }else{
            if(xf>=200){
                System.out.println("本次实际消费金额:"+ 0.9*xf);
            }else{
                System.out.println("本次实际消费金额:"+ xf);
            }
        }
    }


}
