package com.bing.school.p12;

/**
 * 轿车
 */
public class MiniCar extends Car {
    // 轿车没有自己的属性
    public MiniCar() {
    }
    public MiniCar(String no, String name, String color, double rent,boolean status) {
        super(no, name, color, rent,status);
    }

    // 轿车重写计算总租金的方法
    @Override
    public double calcPrice() {
        // 租用天数在7天以内，按照日租金计算总价，超过7天的部分，每天加收10%的租金费用
        double total = this.getRent() * this.getDays();
        if(this.getDays()>7){
            int d = this.getDays()-7;
            total += this.getRent()*0.1*d;
        }
        return total;
    }
}
