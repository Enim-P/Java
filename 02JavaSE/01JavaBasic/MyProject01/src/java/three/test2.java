package three;

/**
 *  do-while 循环
 */
public class test2 {
    public static void main(String[] args) {
        int i = 11;
        while(i<10){
            System.out.println("好好学习");
            i++;
        }
        // 总结：如果循环的条件不成立，while循环一次都不执行。因为while循环是先判断再执行
        System.out.println("------------");
        int j = 10;
        do{
            System.out.println(j+"好好学习");
            j++; // 循环变量重新赋值
        }while(j<10);
        System.out.println(j);
        // 总结： do-while循环会先执行一次循环体，然后再判断循环条件，如果条件成立，在继续执行循环体
        // 所以， do-while循环无论煦暖条件是否成立，肯定会执行第一次循环体

    }
}
