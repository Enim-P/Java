package p4;

/**
 * 学生类
 */
public class Student {
    //学生的成绩数组
    int[] scores = new int[10];
    Student(){
        //在构造方法中，初始化数组的前3个空间
        scores[0] = 55;
        scores[1] = 66;
        scores[2] = 38;
    }

    //显示学生的所有成绩
    void show(){
        System.out.println("学生的成绩如下：");
        for (int score : scores){
            if(score!=0){
                System.out.println(score);
            }
        }
    }

    //添加新的成绩
    void addScore(int score){
        // 循环整个数组
        for(int i=0;i<scores.length;i++){
            // 找一个空的空间
            if(scores[i]==0){
                scores[i] = score;
                break;   //如果不加break，数组会全部放满
            }
            // 如果循环到最后一次了，没有找到空的空间
            if(i==scores.length-1){
                System.out.println("存储空间已满！");
            }
        }
    }
}
