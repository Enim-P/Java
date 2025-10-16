package two;

import java.util.Scanner;

/**
 * 嵌套if选择结构
 * */
public class test7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入性别（男/女）");
        String sex = input.next();
        // 注意：判断字符串的内容是否相等，使用equals
        if(sex.equals("男")){
            System.out.println("进入男子组");
            System.out.print("请输入你的百米成绩：");
            double score = input.nextDouble();
            // 一个完美的if结构，定义在另一个或else结构内部，这样的if结构就是嵌套if选择结构
            if(score< 10){
                System.out.println("进入决赛");
            }else{
                System.out.println("无缘决赛");
            }
        }else {
            System.out.println("进入女子组");
        }
    }
}
