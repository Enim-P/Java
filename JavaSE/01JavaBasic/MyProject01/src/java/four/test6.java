package four;
/**
 * 练习
 */
public class test6 {
    public static void main(String[] args) {
        /*
            鸡兔同笼，现在有25个头，94只脚
//            请问鸡和兔有多少个？
        */
        for(int i=1; i<25;i++){
            for(int j =(25-i);j<25;j++){
                if(i+j==25&&i*2+j*4==94){
                    System.out.println("鸡有"+i+"只，兔子有"+j+"只。");
                    break;
                }
            }

        }
    }
}
