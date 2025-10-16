package com.bing.school.p12;

/**
 * 卡车
 */
public class Turck extends Car{
    //载重
    private int load;

    public Turck() {
    }

    public Turck(String no, String name, String color, double rent,boolean status, int load) {
        super(no, name, color, rent,status);
        this.load = load;
    }

    public int getLoad() {
        return load;
    }

    public void setLoad(int load) {
        this.load = load;
    }

    //卡车重写计算总价的方法
    @Override
    public double calcPrice() {
        // 租用天数在7天以内，按照日租金计算总价，超过7天的部分，以10吨作为一个单位量，加收日租金的15%
        double total = this.getRent() * this.getDays();
        if(this.getDays()>7){
            int d = this.getDays()-7;  //技术超出的天数
            int b = (int)Math.ceil(this.getLoad()/10.0);  //计算有多少个10吨的单位量
            total += this.getRent()*0.15*d*b;
        }
        return total;
    }
}
