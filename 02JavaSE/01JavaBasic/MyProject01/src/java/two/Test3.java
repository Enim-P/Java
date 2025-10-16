package two;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Scanner;

/**
 * 多重if选择结构
 * */
public class Test3 {
    public static void main(String[] args) {
        /*
            输入你的存款金额，判断你能买什么车
            500 -> 迈巴赫
            200 -> 奥迪A8
            100 -> 宝马5
            50  -> 大众迈腾
            10  -> 比亚迪
            否则 -> 暂时先不买
         */
        Scanner input = new Scanner(System.in);
        System.out.print("请输入您的存款金额（单位是万）");
        int money = input.nextInt();
        if(money>=500){
            System.out.println("迈巴赫");
        }else if (money>=200 ){
            System.out.println("奥迪A8");
        } else if (money>=100){
            System.out.println("宝马5");
        }else if(money>=50){
            System.out.println("大众迈腾");
        }else if(money>=10){
            System.out.println("比亚迪");
        }else if(money>=10){
            System.out.println("暂时先不买");
        }

        // 使用多重if选择结构时，判断大于要先比较大数，判断小于要先选择小数，否则就要写完整条件
        }
    }


