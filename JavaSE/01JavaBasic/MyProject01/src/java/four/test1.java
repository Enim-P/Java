package four;
/**
 * 调试程序
 */
public class test1 {
    public static void main(String[] args) {
        // 调试程序的三步骤： 1. 设置断点 2.单步运行 3.观察变量
        // 需要在有问题的代码出设置一个断点，采用调试运行程序
        // 程序运行到断点处会停住，此时程序员需要受手动控制，采用单步运行程序
        // 在单步运行程序的过程中，观察程序的走向和程序中变量的变化，从而发现问题并解决问题
        System.out.println("Hello");
        System.out.println("world");
        // 打印1-5
        for(int i =1;i<5;i++){
            System.out.println(i);
        }
    }
}
