package p9;

import java.util.Random;

/**
 * 电脑
 */
public class Computer {
    /**
     * 姓名
     */
    String name;
    /**
     * 积分
     */
    int score;

    Computer(){}
    Computer(String name){
        this.name = name;
    }

    /**
     * 出拳方法
     * @return 出拳的数字编号
     */
    int cq(){
        Random r = new Random();
        // 随机返回一个1-3之间的数
        int no = r.nextInt(3)+1;
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
