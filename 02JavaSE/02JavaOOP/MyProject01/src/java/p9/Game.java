package p9;

import java.util.Scanner;

/**
 * 游戏类
 */
public class Game {
    Scanner input = new Scanner(System.in);
    /**
     * 玩家
     */
    Person p;
    /**
     * 电脑
     */
    Computer c;

    /**
     * 初始化方法
     */
    void init(){
        System.out.println("*************欢迎使用人机猜拳游戏***************");
        System.out.print("玩家请输入姓名：");
        String name1 = input.next();
        System.out.print("请给电脑输入一个姓名：");
        String name2 = input.next();
        //初始化玩家和电脑
        p = new Person(name1);
        c = new Computer(name2);
        System.out.println(p.name + " VS "+c.name+" 对战即将开开始，敬请期待....");
    }

    /**
     * 开始方法
     */
    void start(){
        // 是否开始比赛（输入y开始比赛，输入n直接退出）
        System.out.print("是否开始比赛(y/n):");
        String jx = input.next();
        if(jx.equals("n")) return;  //直接跳出方法
        while(jx.equals("y")){
            // 玩家先出拳
            int pcq = p.cq();
            // 电脑后出拳
            int ccq = c.cq();
            // 判断玩家赢的情况
            if(pcq==1&&ccq==3 || pcq==2&&ccq==1 || pcq==3&&ccq==2){
                System.out.println("本局比赛"+p.name+"获胜");
                p.score+=3;   //积分加3分
            }else if(ccq==1&&pcq==3 || ccq==2&&pcq==1 || ccq==3&&pcq==2){
                // 判断电脑赢的情况
                System.out.println("本局比赛"+c.name+"获胜");
                c.score+=3;   //积分加3分
            }else{
                // 判断双方打平的情况
                System.out.println("本局比赛双方打平");
                // 双方积分都加1分
                p.score+=1;
                c.score+=1;
            }
            // 是否继续比赛（输入y继续比赛，输入n结束比赛，并比较双方的积分，判断获胜方）
            System.out.print("是否继续比赛(y/n):");
            jx = input.next();
        }
        // 判断对战结果
        System.out.println("-----------------------------");
        System.out.println(p.name+"的总积分："+p.score);
        System.out.println(c.name+"的总积分："+c.score);
        if(p.score>c.score){
            System.out.println("玩家获得最终胜利！");
        }else if(c.score>p.score){
            System.out.println("电脑获得最终胜利！");
        }else{
            System.out.println("玩家和电脑最终打成了平时！");
        }
        System.out.println("-----------------------------");
    }
}
