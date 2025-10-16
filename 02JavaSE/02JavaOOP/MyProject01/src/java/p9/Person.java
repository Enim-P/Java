package p9;

import java.util.Scanner;

/**
 * 人类
 */
public class Person {
    /**
     * 姓名
     */
    String name;
    /**
     * 积分
     */
    int score;

    Person(){}
    Person(String name){
        this.name = name;
    }

    /**
     * 出拳方法
     * @return 出拳的数字编号
     */
    int cq(){
        Scanner input = new Scanner(System.in);
        System.out.print(this.name+"请出拳：1.剪刀 2.石头 3.布：");
        int no = input.nextInt();
        if(no==1){
            System.out.println(this.name+"出拳：剪刀");
        }else if(no==2){
            System.out.println(this.name+"出拳：石头");
        }else{
            System.out.println(this.name+"出拳：布");
        }
        return no;
    }
}
