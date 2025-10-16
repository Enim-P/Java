package three;
/**
 * for循环
 */
public class test5 {
    public static void main(String[] args) {
        int i = 1;
        while(i<=5){
            System.out.println(i+"好好学习");
            i++;
        }
        System.out.println("-----------");
        // 循环三要素： 1.循环变量 2.循环条件 3. 循环变量重新赋值
        // while循环和do-while循环，这三要素是分开定义的，分开定义的问题在于某些部分会遗忘
        // 这个时候我们就引出了for循环
        // for循环的三要素可以放在一起定义，这样就不会遗忘任何一个部分了
        for(int j=1;j<=5;j++){
            System.out.println(j+"天天向上");
        }
        System.out.println("-----------");
        // for循环的（）里面，如果只打上两个分号就是一个死循环，功能类似于while（true）
       /* for(;;){
            System.out.println("hahaha");
        }*/
        System.out.println("-----------");
        // 循环变量可以定义多个
        for(int m = 1, n = 5; m<=5; m++,n--){
            System.out.println(m+"+"+n+"="+(m+n));
        }
    }
}
