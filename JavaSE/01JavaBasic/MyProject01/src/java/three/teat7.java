package three;

/**
 * 循环的跳出语句
 */
public class teat7 {
    public static void main(String[] args) {
        for(int i=0;i<=10;i++){
            System.out.println(i+"好好学习");
            if(i==5){
                // break语句，在循环中使用，表示跳出整个循环
                // break语句，之前再case语句中也使用过，表示体跳出整个switch
                break;
            }
        }
        System.out.println("end");
        System.out.println("--------------");
        for(int i=0;i<=10;i++){
            if(i==5){
                // continue语句，表示跳过当次循环，继续执行后面的循环
                continue;
            }
            System.out.println(i+"天天向上");
        }
        System.out.println("end");
    }
}
